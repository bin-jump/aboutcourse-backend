package com.aboutcourse.course.domain.repository;

import com.aboutcourse.course.domain.entity.School;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository {

    School create(School school);
}
