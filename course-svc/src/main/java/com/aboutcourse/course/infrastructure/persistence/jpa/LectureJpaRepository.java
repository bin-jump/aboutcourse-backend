package com.aboutcourse.course.infrastructure.persistence.jpa;

import com.aboutcourse.course.domain.entity.Lecture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LectureJpaRepository extends JpaRepository<Lecture, Long> {

    List<Lecture> findTop10ByTitleStartingWithAndSchoolIdAndMajorId(String prefix, Long schoolId, Long majorId);

    @Query("SELECT l FROM Lecture l WHERE (:schoolId is null or l.schoolId = :schoolId) " +
            "and (:majorId is null or l.majorId = :majorId)")
    Page<Lecture> findBySchoolMajor(@Param("schoolId") Long schoolId, @Param("majorId") Long majorId,
                                    Pageable pageable);
}
