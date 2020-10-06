package com.aboutcourse.schedule.domain.repository;

import com.aboutcourse.schedule.domain.entity.valueobject.LectureTask;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureTaskRepository {

    LectureTask create();

    void remove(LectureTask lectureTask);
}
