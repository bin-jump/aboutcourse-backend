package com.aboutcourse.course.infrastructure.persistence;

import com.aboutcourse.course.domain.entity.Lecture;
import com.aboutcourse.course.domain.repository.LectureSearchRepository;
import com.aboutcourse.course.infrastructure.persistence.jpa.LectureJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LectureSearchRepositoryImpl implements LectureSearchRepository {

    @Autowired
    LectureJpaRepository lectureJpaRepository;

    @Override
    public void save(Lecture lecture) {

    }

    @Override
    public List<Lecture> search(String title, Long schoolId, Long majorId) {

        return lectureJpaRepository
                .findTop10ByTitleStartingWithAndSchoolIdAndMajorId(title, schoolId, majorId);
    }
}
