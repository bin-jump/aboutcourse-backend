package com.aboutcourse.course.domain.repository;

import com.aboutcourse.course.domain.entity.Lecture;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectureSearchRepository {

    void save(Lecture lecture);

    List<Lecture> search(String title, Long schoolId, Long majorId);

}
