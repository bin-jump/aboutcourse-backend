package com.aboutcourse.course.application;

import com.aboutcourse.course.application.assembler.CommentAssembler;
import com.aboutcourse.course.application.assembler.ReviewAssembler;
import com.aboutcourse.course.domain.entity.Comment;
import com.aboutcourse.course.domain.entity.Review;
import com.aboutcourse.course.domain.service.ReviewService;
import com.aboutcourse.course.dto.CommentDto;
import com.aboutcourse.course.dto.ReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewApplicationService {


    @Autowired
    ReviewService reviewService;

    @Transactional
    public ReviewDto createReview(Long studentId, ReviewDto reviewDto) {

        Review review = reviewService.createReview(studentId, reviewDto.getLectureId(),
                reviewDto.getBody(), reviewDto.getCourseScore());

        return ReviewAssembler.toDto(review);
    }

    @Transactional
    public CommentDto createComment(Long studentId, CommentDto commentDto) {

        Comment comment = reviewService.createComment(studentId, commentDto.getReviewId(),
                commentDto.getBody());

        return CommentAssembler.toDto(comment);
    }

}
