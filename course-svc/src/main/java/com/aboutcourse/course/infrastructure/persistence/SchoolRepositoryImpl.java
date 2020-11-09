package com.aboutcourse.course.infrastructure.persistence;

import com.aboutcourse.course.domain.entity.School;
import com.aboutcourse.course.domain.repository.SchoolRepository;
import com.aboutcourse.course.infrastructure.persistence.jpa.SchoolJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SchoolRepositoryImpl implements SchoolRepository {

    @Autowired
    SchoolJpaRepository schoolJpaRepository;

    @Override
    public School create(School school) {
        return schoolJpaRepository.save(school);
    }

    @Override
    public School update(School school) {
        return schoolJpaRepository.save(school);
    }

    @Override
    public List<School> getAll() {
        return schoolJpaRepository.findAll();
    }

    @Override
    public School getById(Long id) {
        return schoolJpaRepository.findById(id).orElse(null);
    }
}
