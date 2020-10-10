package com.aboutcourse.schedule.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDto {

    private Long id;

    @NotBlank
    private String title;

    private long startDate;

    private long dueDate;

    private long startTime;

    private long endTime;

    private boolean period;

    private String repeat;

    @Singular
    private List<TagDto> tags = new ArrayList<>();;

    private String info;

}
