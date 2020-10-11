package com.aboutcourse.course.domain.repository;

import com.aboutcourse.course.domain.entity.Lecture;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectureRepository {

    Lecture create(Lecture lecture);

    Lecture getById(Long id);

    List<Lecture> getByIds(List<Long> ids);
}
