package com.aboutcourse.course.domain.repository;

import com.aboutcourse.course.domain.entity.Major;
import org.springframework.stereotype.Repository;

@Repository
public interface MajorRepository {

    Major create(Major major);
}
