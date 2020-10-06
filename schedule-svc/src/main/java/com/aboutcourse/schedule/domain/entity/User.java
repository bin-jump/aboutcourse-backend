package com.aboutcourse.schedule.domain.entity;


import com.aboutcourse.common.shared.Entity;
import com.aboutcourse.schedule.domain.entity.valueobject.LectureTask;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class User extends Entity<User> {

    private String name;

    private List<Task> tasks = new ArrayList<>();

    private List<LectureTask> lectures = new ArrayList<>();

    private List<Task> tasksRemove = new ArrayList<>();

    private List<LectureTask> lecturesRemove = new ArrayList<>();

    public void addTask(Task task) {
        tasksRemove.remove(task);
        tasks.add(task);
    }

    public void addLecture(LectureTask lectureTask) {
        lectures.add(lectureTask);
        lecturesRemove.remove(lectureTask);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
        tasksRemove.add(task);
    }

    public void removeLecture(LectureTask lectureTask) {
        lectures.remove(lectureTask);
        lecturesRemove.add(lectureTask);
    }
}
