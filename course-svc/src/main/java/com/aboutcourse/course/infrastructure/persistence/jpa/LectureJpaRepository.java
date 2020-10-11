package com.aboutcourse.course.infrastructure.persistence.jpa;

import com.aboutcourse.course.domain.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureJpaRepository extends JpaRepository<Lecture, Long> {
}
