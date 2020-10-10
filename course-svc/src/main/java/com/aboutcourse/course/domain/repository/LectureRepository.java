package com.aboutcourse.course.domain.repository;

import com.aboutcourse.course.domain.entity.Lecture;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectureRepository {

    Lecture create(Lecture lecture);

    //List<Lecture> getByUser(long uid);
}
