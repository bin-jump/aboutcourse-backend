package com.aboutcourse.schedule.domain.service;

import com.aboutcourse.common.error.InvalidValueException;
import com.aboutcourse.common.error.ResourceNotFoundException;
import com.aboutcourse.schedule.domain.entity.LectureItem;
import com.aboutcourse.schedule.domain.entity.Tag;
import com.aboutcourse.schedule.domain.entity.Task;
import com.aboutcourse.schedule.domain.entity.User;
import com.aboutcourse.schedule.domain.entity.valueobject.RepeatType;
import com.aboutcourse.schedule.domain.repository.TagRepository;
import com.aboutcourse.schedule.domain.repository.TaskRepository;
import com.aboutcourse.schedule.domain.repository.UserRepository;
import com.aboutcourse.schedule.domain.service.command.CreateTaskCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    @Autowired
    TagRepository tagRepository;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    public Task createTask(CreateTaskCommand command) {
        User user = userRepository.getById(command.getUserId());
        if (user == null) {
            throw new ResourceNotFoundException("user not found");
        }
        if (command.getRepeat() != RepeatType.NONE &&
                command.getStartDate().after(command.getDueDate())) {
            throw new InvalidValueException("invalid task date");
        }
        if (command.getStartTime().after(command.getEndTime())) {
            throw new InvalidValueException("invalid task date");
        }

        Map<String, Tag> existTags = tagRepository.findByNames(command.getUserId(),
                command.getTags().stream().map(CreateTaskCommand.TagItem::getLabel)
                        .collect(Collectors.toList()))
                .stream().collect(Collectors.toMap(Tag::getLabel, t -> t));

        Task task = Task.builder()
                .title(command.getTitle())
                .startDate(command.getStartDate())
                .dueDate(command.getRepeat() == RepeatType.NONE ?
                        command.getStartDate() : command.getDueDate())
                .startTime(command.getStartTime())
                .endTime(command.getEndTime())
                .period(command.isPeriod())
                .repeat(command.getRepeat())
                .info(command.getInfo())
                .build();

        command.getTags().forEach(e -> {
            Tag tag = existTags.containsKey(e.getLabel()) ? existTags.get(e.getLabel()) :
                    new Tag(e.getId(), command.getUserId(), e.getLabel());
            task.getTags().add(tag);
        });

        trimWeekPeriodTask(task);

//        user.addTask(task);
//        User updated = userRepository.update(user);
        task.setUser(user);
        return taskRepository.create(task);
    }

    public void addUserLecture(long lid, long uid) {
        User user = userRepository.getById(uid);
        if (user == null) {
            throw new ResourceNotFoundException("user not found");
        }

        user.addLecture(new LectureItem(lid, user));
        userRepository.update(user);
    }

    public void removeTask(long uid, long tid) {
        User user = userRepository.getById(uid);
        if (user == null) {
            throw new ResourceNotFoundException("user not found");
        }

        Task task = user.getTasks()
                .stream().filter(t -> t.getId().equals(tid))
                .findFirst().orElse(null);
        if (task == null) {
            return;
        }
        user.removeTask(task);
        userRepository.update(user);
    }

    public void removeLecture(long uid, long lid) {
        User user = userRepository.getById(uid);
        if (user == null) {
            throw new ResourceNotFoundException("user not found");
        }

        LectureItem task = user.getLectures()
                .stream().filter(t -> t.getLectureId() == lid)
                .findFirst().orElse(null);
        user.removeLecture(task);
        userRepository.update(user);
    }

    /**
     * trim unnecessary task due date,
     * if task has period and repeat type is week.
     * @param task
     */
    private void trimWeekPeriodTask(Task task) {
        if (task.isPeriod() && task.getRepeat() == RepeatType.WEEK) {
            int wdStart = getWeekDay(task.getStartDate());
            int wdEnd = getWeekDay(task.getDueDate());
            int diff = (wdEnd + 7 - wdStart) % 7;
            task.setDueDate(new Date(task.getDueDate().getTime() -
                    diff * 24 * 3600 * 1000));
        }
    }

    private int getWeekDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_WEEK);
    }
}
