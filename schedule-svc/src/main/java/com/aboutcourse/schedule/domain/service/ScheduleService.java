package com.aboutcourse.schedule.domain.service;

import com.aboutcourse.schedule.domain.entity.LectureItem;
import com.aboutcourse.schedule.domain.entity.Tag;
import com.aboutcourse.schedule.domain.entity.Task;
import com.aboutcourse.schedule.domain.entity.User;
import com.aboutcourse.schedule.domain.repository.UserRepository;
import com.aboutcourse.schedule.domain.service.command.CreateTaskCommand;
import org.springframework.beans.factory.annotation.Autowired;

//@Component
public class ScheduleService {


    @Autowired
    UserRepository userRepository;

    public Task createTask(CreateTaskCommand command) {

        User user = userRepository.getById(command.getUserId());

        Task task = new Task();
//                Task.builder()
//                .title(command.getTitle())
//                .startDate(command.getStartDate())
//                .dueDate(command.getDueDate())
//                .startTime(command.getStartTime())
//                .endTime(command.getEndTime())
//                .period(command.isPeriod())
//                .repeat(command.getRepeat())
//                .info(command.getInfo())
//                .build();

        command.getTags().forEach(e -> {
            task.getTags().add(new Tag(e.getId(), command.getUserId(), e.getLabel()));
        });

        user.addTask(task);
        userRepository.update(user);

        return task;
    }

    public void AddUserLecture(long lid, long uid) {

        User user = userRepository.getById(uid);
        user.addLecture(new LectureItem(lid, user));

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
        LectureItem task = user.getLectures()
                .stream().filter(t -> t.getLectureId() == lid)
                .findFirst().orElse(null);
        user.removeLecture(task);
        userRepository.update(user);
    }

}
