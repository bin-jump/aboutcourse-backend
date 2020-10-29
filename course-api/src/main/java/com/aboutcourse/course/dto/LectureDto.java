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

    private Long schoolId;

    private Long majorId;

    @NotBlank
    private String title;

    private long startDate;

    private long dueDate;

    @Builder.Default
    private List<TimeIntervalDto> intervals = new ArrayList<>();

    private String info;

}
