package com.aboutcourse.course.domain.service.command;

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
public class CreateLectureCommand {

    private long userId;

    private String title;

    private Date startDate;

    private Date dueDate;

    private List<TimeInterval> intervals = new ArrayList<>();

    private String info;

}
