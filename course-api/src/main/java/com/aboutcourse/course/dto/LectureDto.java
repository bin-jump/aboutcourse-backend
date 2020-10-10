package com.aboutcourse.course.dto;

import lombok.*;

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

    @Singular
    private List<TimeIntervalDto> intervals = new ArrayList<>();

    private String info;

}
