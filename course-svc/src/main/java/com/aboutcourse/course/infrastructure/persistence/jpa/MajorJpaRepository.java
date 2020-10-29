package com.aboutcourse.course.infrastructure.persistence.jpa;

import com.aboutcourse.course.domain.entity.Major;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MajorJpaRepository extends JpaRepository<Major, Long> {
}
