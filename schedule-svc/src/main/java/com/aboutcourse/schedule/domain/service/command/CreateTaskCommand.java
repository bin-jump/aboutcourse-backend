package com.aboutcourse.schedule.domain.service.command;

import com.aboutcourse.schedule.domain.entity.valueobject.RepeatType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CreateTaskCommand {

    private long userId;

    private String title;

    private Date startDate;

    private Date dueDate;

    private Date startTime;

    private Date endTime;

    private boolean period;

    private RepeatType repeat = RepeatType.NONE;

    private List<TagItem> tags = new ArrayList<>();

    private String info;

    @Getter
    @Setter
    @NoArgsConstructor
    public class TagItem {

        private Long id;

        private String label;
    }
}
