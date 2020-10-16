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

    private Long startDate;

    private Long dueDate;

    private Long startTime;

    private Long endTime;

    private boolean period;

    private String repeat;

    @Builder.Default
    private List<TagDto> tags = new ArrayList<>();

    private String info;

}
