package com.aboutcourse.course.infrastructure.persistence;

import com.aboutcourse.course.domain.entity.Major;
import com.aboutcourse.course.domain.repository.MajorRepository;
import com.aboutcourse.course.infrastructure.persistence.jpa.MajorJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MajorRepositoryImpl implements MajorRepository {

    @Autowired
    MajorJpaRepository majorJpaRepository;

    @Override
    public Major create(Major major) {
        return majorJpaRepository.save(major);
    }

}
