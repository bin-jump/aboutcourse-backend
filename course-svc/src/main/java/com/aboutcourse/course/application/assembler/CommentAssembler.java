package com.aboutcourse.course.application.assembler;

import com.aboutcourse.course.domain.entity.Comment;
import com.aboutcourse.course.dto.CommentDto;

public class CommentAssembler {

    public static CommentDto toDto(Comment comment) {

        CommentDto commentDto = CommentDto.builder()
                .id(comment.getId())
                .body(comment.getBody())
                .reviewId(comment.getReviewId())
                .created(comment.getCreated().getTime())
                .user(StudentAssembler.toDto(comment.getStudent()))
                .build();

        return commentDto;
    }
}
