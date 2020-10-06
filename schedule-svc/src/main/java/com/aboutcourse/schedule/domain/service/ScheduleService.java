package com.aboutcourse.schedule.domain.service;

import com.aboutcourse.schedule.domain.entity.Tag;
import com.aboutcourse.schedule.domain.entity.Task;
import com.aboutcourse.schedule.domain.entity.User;
import com.aboutcourse.schedule.domain.entity.valueobject.LectureTask;
import com.aboutcourse.schedule.domain.entity.valueobject.RepeatType;
import com.aboutcourse.schedule.domain.repository.LectureTaskRepository;
import com.aboutcourse.schedule.domain.repository.TaskRepository;
import com.aboutcourse.schedule.domain.repository.UserRepository;
import com.aboutcourse.schedule.domain.service.command.CreateTaskCommand;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduleService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    LectureTaskRepository lectureTaskRepository;

    public Task createTask(CreateTaskCommand command) {

        User user = userRepository.getById(command.getUserId());

        Task task = Task.builder()
                .title(command.getTitle())
                .startDate(command.getStartDate())
                .dueDate(command.getDueDate())
                .startTime(command.getStartTime())
                .endTime(command.getEndTime())
                .period(command.isPeriod())
                .repeat(command.getRepeat())
                .info(command.getInfo())
                .build();

        command.getTags().forEach(e -> {
            task.getTags().add(new Tag(e.getId(), command.getUserId(), e.getLabel()));
        });

        user.addTask(task);
        userRepository.update(user);

        return task;
    }

    public void AddUserLecture(long lid, long uid) {

        User user = userRepository.getById(uid);

        user.addLecture(new LectureTask(uid, lid));

        userRepository.update(user);

    }

    public void removeTask(long uid, long tid) {
        User user = userRepository.getById(uid);
        Task task = user.getTasks()
                .stream().filter(t -> t.getId().equals(tid))
                .findFirst().orElse(null);
        user.removeTask(task);
        userRepository.update(user);
    }

    public void removeLecture(long uid, long lid) {
        User user = userRepository.getById(uid);
        LectureTask task = user.getLectures()
                .stream().filter(t -> t.getLectureId() == lid)
                .findFirst().orElse(null);
        user.removeLecture(task);
        userRepository.update(user);
    }

}
