package com.aboutcourse.schedule.infrastructure.persistence.jpa.repository;

import com.aboutcourse.schedule.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepsitory extends JpaRepository<User, Long> {
}
