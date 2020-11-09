package com.aboutcourse.course.infrastructure.persistence;

import com.aboutcourse.common.service.PageResult;
import com.aboutcourse.course.domain.entity.Comment;
import com.aboutcourse.course.domain.entity.Review;
import com.aboutcourse.course.domain.repository.ReviewRepository;
import com.aboutcourse.course.infrastructure.persistence.jpa.CommentJpaRepository;
import com.aboutcourse.course.infrastructure.persistence.jpa.ReviewJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewRepositoryImpl implements ReviewRepository {

    @Autowired
    ReviewJpaRepository reviewJpaRepository;

    @Autowired
    CommentJpaRepository commentJpaRepository;

    @Override
    public PageResult<Review> findByLectureId(Long lectureId, int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<Review> paged = reviewJpaRepository.findByLectureId(lectureId, paging);

        return PageResult.<Review>builder()
                .data(paged.getContent())
                .total(paged.getTotalElements())
                .totalPage(paged.getTotalPages())
                .pageNumber(paged.getNumber())
                .build();
    }

    @Override
    public PageResult<Comment> findReviewComment(Long reviewId, int page, int size) {

        Pageable paging = PageRequest.of(page, size);
        Page<Comment> paged = commentJpaRepository.findByReviewId(reviewId, paging);

        return PageResult.<Comment>builder()
                .data(paged.getContent())
                .total(paged.getTotalElements())
                .totalPage(paged.getTotalPages())
                .pageNumber(paged.getNumber())
                .build();
    }

    @Override
    public Review create(Review review) {
        return reviewJpaRepository.save(review);
    }

    @Override
    public Comment createComment(Comment comment) {
        return commentJpaRepository.save(comment);
    }
}
