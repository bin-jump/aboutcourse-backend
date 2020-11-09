package com.aboutcourse.course.domain.repository;

import com.aboutcourse.common.service.PageResult;
import com.aboutcourse.course.domain.entity.Comment;
import com.aboutcourse.course.domain.entity.Review;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository {

    PageResult<Review> findByLectureId(Long lectureId, int page, int size);

    PageResult<Comment> findReviewComment(Long reviewId, int page, int size);

    Review create(Review review);

    Comment createComment(Comment comment);
}
