package com.aboutcourse.course.application.assembler;

import com.aboutcourse.course.domain.entity.Review;
import com.aboutcourse.course.dto.ReviewDto;

public class ReviewAssembler {

    public static ReviewDto toDto(Review review) {

        ReviewDto reviewDto = ReviewDto.builder()
                .id(review.getId())
                .lectureId(review.getLectureId())
                .body(review.getBody())
                .courseScore(review.getCourseScore())
                .created(review.getCreated().getTime())
                .user(StudentAssembler.toDto(review.getStudent()))
                .build();

        return reviewDto;
    }
}
