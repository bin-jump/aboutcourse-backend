package com.aboutcourse.course.infrastructure.persistence.jpa;

import com.aboutcourse.course.domain.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LectureJpaRepository extends JpaRepository<Lecture, Long> {

    List<Lecture> findTop10ByTitleStartingWithAndSchoolIdAndMajorId(String prefix, Long schoolId, Long majorId);
}
