package com.aboutcourse.course.domain.repository;

import com.aboutcourse.course.domain.entity.School;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository {

    School create(School school);

    School update(School school);

    List<School> getAll();

    School getById(Long id);
}
