package com.aboutcourse.course.infrastructure.persistence;


import com.aboutcourse.course.domain.entity.Lecture;
import com.aboutcourse.course.domain.repository.LectureRepository;
import com.aboutcourse.course.infrastructure.persistence.jpa.LectureJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LectureRepositoryImpl implements LectureRepository {

    @Autowired
    LectureJpaRepository lectureJpaRepository;

    @Override
    public Lecture create(Lecture lecture) {
        return lectureJpaRepository.save(lecture);
    }

    @Override
    public Lecture getById(Long id) {
        return lectureJpaRepository.findById(id).get();
    }

    @Override
    public List<Lecture> getByIds(List<Long> ids) {
        return lectureJpaRepository.findAllById(ids);
    }
}
