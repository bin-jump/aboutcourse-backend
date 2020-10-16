package com.aboutcourse.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskItemDto<T> {

    private TaskType taskType;

    private T task;

    public enum TaskType {
        TASK, LECTURE
    }
}
