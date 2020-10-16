package com.aboutcourse.schedule.infrastructure.persistence.jpa.repository;

import com.aboutcourse.schedule.domain.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskJpaRepository extends JpaRepository<Task, Long> {
}
