package com.aboutcourse.schedule.domain.entity;


import com.aboutcourse.common.shared.EntityBase;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User extends EntityBase<User> {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "school", nullable = false)
    private String school;

    @Column(name = "major", nullable = false)
    private String major;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    @Builder.Default
    private Set<Task> tasks = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    @Builder.Default
    private Set<LectureItem> lectures = new HashSet<>();


    public void addTask(Task task) {
        task.setUser(this);
        this.tasks.add(task);
    }

    public void addLecture(LectureItem lectureTask) {
        lectureTask.setUser(this);
        this.lectures.add(lectureTask);
    }

    public void removeTask(Task task) {
        this.tasks.remove(task);
    }

    public void removeLecture(LectureItem lectureTask) {
        this.lectures.remove(lectureTask);
    }
}
