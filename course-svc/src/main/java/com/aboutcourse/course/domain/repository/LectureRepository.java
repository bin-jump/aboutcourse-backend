package com.aboutcourse.course.domain.repository;

import com.aboutcourse.common.service.PageResult;
import com.aboutcourse.course.domain.entity.Lecture;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectureRepository {

    Lecture create(Lecture lecture);

    void update(Lecture lecture);

    Lecture getById(Long id);

    List<Lecture> getByIds(List<Long> ids);

    PageResult<Lecture> getBySchoolMajor(Long schoolId, Long majorId, int page, int size);
}
