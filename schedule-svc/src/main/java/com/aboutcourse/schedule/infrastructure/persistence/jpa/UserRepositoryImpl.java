package com.aboutcourse.schedule.infrastructure.persistence.jpa;

import com.aboutcourse.schedule.domain.entity.User;
import com.aboutcourse.schedule.domain.repository.UserRepository;
import com.aboutcourse.schedule.infrastructure.persistence.jpa.repository.UserJpaRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    UserJpaRepsitory userJpaRepsitory;

    @Override
    public User create(User user) {
        return userJpaRepsitory.save(user);
    }

    @Override
    public User getById(long uid) {
        return userJpaRepsitory.findById(uid).orElse(null);
    }

    @Override
    public User update(User user) {
        return userJpaRepsitory.save(user);
    }
}
