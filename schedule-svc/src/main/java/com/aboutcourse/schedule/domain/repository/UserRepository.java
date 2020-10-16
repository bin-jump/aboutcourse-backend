package com.aboutcourse.schedule.domain.repository;

import com.aboutcourse.schedule.domain.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    User create(User user);

    User getById(long uid);

    User update(User user);
}
