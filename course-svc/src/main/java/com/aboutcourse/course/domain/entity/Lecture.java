package com.aboutcourse.course.domain.entity;

import com.aboutcourse.common.shared.Entity;
import com.aboutcourse.course.domain.entity.valueobject.TimeInterval;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Lecture extends Entity<Lecture> {

    private String title;

    private Date startDate;

    private Date dueDate;

    private List<TimeInterval> intervals = new ArrayList<>();

    private String info;
}
