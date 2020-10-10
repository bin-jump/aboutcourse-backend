package com.aboutcourse.course.infrastructure.search;

import com.aboutcourse.course.domain.entity.Lecture;
import com.aboutcourse.course.domain.repository.LectureSearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LectureSearchRepositoryImpl implements LectureSearchRepository {

    @Override
    public void save(Lecture lecture) {

    }

    @Override
    public List<Lecture> search(String school, String major, String key) {
        return null;
    }
}
