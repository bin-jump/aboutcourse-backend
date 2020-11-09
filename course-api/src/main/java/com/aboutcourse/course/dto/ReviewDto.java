package com.aboutcourse.course.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDto {

    private Long id;

    private Long lectureId;

    private String body;

    private Integer courseScore;

    private Long created;

    private StudentDto user;

}
