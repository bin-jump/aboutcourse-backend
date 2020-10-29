package com.aboutcourse.schedule.application.assembler;

import com.aboutcourse.schedule.domain.entity.Task;
import com.aboutcourse.schedule.dto.TagDto;
import com.aboutcourse.schedule.dto.TaskDto;

public class TaskAssembler {

    public static TaskDto toDto(Task task) {
        TaskDto res = TaskDto.builder()
                .id(task.getId())
                .title(task.getTitle())
                .startDate(task.getStartDate().getTime())
                .dueDate(task.getDueDate().getTime())
                .startTime(task.getStartTime().getTime())
                .endTime(task.getEndTime().getTime())
                .period(task.isPeriod())
                .repeat(task.getRepeat().name())
                .info(task.getInfo())
                .build();

        task.getTags().forEach(t -> {
            res.getTags().add(TagAssembler.toDto(t));
        });

        return res;
    }
}
