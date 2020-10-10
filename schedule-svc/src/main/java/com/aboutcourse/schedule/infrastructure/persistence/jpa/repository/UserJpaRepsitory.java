package com.aboutcourse.schedule.infrastructure.persistence.jpa.repository;

import com.aboutcourse.schedule.domain.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserJpaRepsitory extends CrudRepository<User, Long> {
}
