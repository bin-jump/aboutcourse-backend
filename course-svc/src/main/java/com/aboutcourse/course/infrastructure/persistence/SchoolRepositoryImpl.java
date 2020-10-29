package com.aboutcourse.course.infrastructure.persistence;

import com.aboutcourse.course.domain.entity.School;
import com.aboutcourse.course.domain.repository.SchoolRepository;
import com.aboutcourse.course.infrastructure.persistence.jpa.SchoolJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SchoolRepositoryImpl implements SchoolRepository {

    @Autowired
    SchoolJpaRepository schoolJpaRepository;

    @Override
    public School create(School school) {
        return schoolJpaRepository.save(school);
    }
}
