package com.aboutcourse.course.infrastructure.persistence.jpa;

import com.aboutcourse.course.domain.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolJpaRepository extends JpaRepository<School, Long> {
}
