package com.aboutcourse.course.infrastructure.persistence.jpa;

import com.aboutcourse.course.domain.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentJpaRepository extends JpaRepository<Comment, Long> {

    Page<Comment> findByReviewId(Long reviewId, Pageable pageable);
}
