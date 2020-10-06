package com.aboutcourse.schedule.domain.entity;

import com.aboutcourse.common.shared.Entity;
import com.aboutcourse.schedule.domain.entity.valueobject.RepeatType;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task extends Entity<Task> {

    private long userId;

    private String title;

    private Date startDate;

    private Date dueDate;

    private Date startTime;

    private Date endTime;

    private boolean period;

    private RepeatType repeat = RepeatType.NONE;

    private List<Tag> tags = new ArrayList<>();

    private String info;

}
