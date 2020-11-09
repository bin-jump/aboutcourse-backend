package com.aboutcourse.course.presentation.controller;

import com.aboutcourse.common.api.BaseResponse;
import com.aboutcourse.common.auth.AuthContext;
import com.aboutcourse.course.application.ReviewApplicationService;
import com.aboutcourse.course.domain.repository.ReviewRepository;
import com.aboutcourse.course.dto.CommentDto;
import com.aboutcourse.course.dto.ReviewDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/review")
@Validated
public class ReviewController {

    @Autowired
    ReviewApplicationService reviewApplicationService;

    @Autowired
    ReviewRepository reviewRepository;

    @PostMapping
    public BaseResponse<ReviewDto> createReview(@RequestBody ReviewDto reviewDto) {

        ReviewDto res = reviewApplicationService
                .createReview(AuthContext.getUserId(), reviewDto);

        return new BaseResponse<>(res);
    }

    @PostMapping("{id}/comment")
    public BaseResponse<CommentDto> createComment(@PathVariable Long id,
                                                  @RequestBody CommentDto commentDto) {
        commentDto.setReviewId(id);
        CommentDto res = reviewApplicationService
                .createComment(AuthContext.getUserId(), commentDto);

        return new BaseResponse<>(res);
    }



}
