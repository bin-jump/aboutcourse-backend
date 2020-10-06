package com.aboutcourse.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LectureDto {

    private Long id;

    @NotBlank
    private String title;

    private long startDate;

    private long dueDate;

    private List<TimeIntervalDto> intervals = new ArrayList<TimeIntervalDto>();

    private String info;

}
