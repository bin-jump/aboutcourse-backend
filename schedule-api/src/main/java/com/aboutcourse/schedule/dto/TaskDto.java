package com.aboutcourse.schedule.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private List<TagDto> tags = new ArrayList<TagDto>();

    private String info;

}
