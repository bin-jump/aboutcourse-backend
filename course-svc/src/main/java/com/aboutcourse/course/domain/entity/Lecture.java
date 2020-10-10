package com.aboutcourse.course.domain.entity;

import com.aboutcourse.common.shared.Entity;
import com.aboutcourse.course.domain.entity.valueobject.TimeInterval;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lecture extends Entity<Lecture> {

    private String title;

    private Date startDate;

    private Date dueDate;

    @Singular
    private List<TimeInterval> intervals = new ArrayList<>();

    private String info;
}
