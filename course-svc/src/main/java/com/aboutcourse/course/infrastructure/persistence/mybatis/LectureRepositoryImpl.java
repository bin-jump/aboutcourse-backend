package com.aboutcourse.course.infrastructure.persistence.mybatis;

import com.aboutcourse.course.domain.entity.Lecture;
import com.aboutcourse.course.domain.repository.LectureRepository;
import org.springframework.stereotype.Repository;

@Repository
public class LectureRepositoryImpl implements LectureRepository {
    @Override
    public Lecture create(Lecture lecture) {
        return lecture;
    }
}
