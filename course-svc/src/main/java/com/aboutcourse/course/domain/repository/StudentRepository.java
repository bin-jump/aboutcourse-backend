package com.aboutcourse.course.domain.repository;

import com.aboutcourse.course.domain.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository {

    Student create(Student student);

    Student getByName(String name);

    Student getById(Long id);
}
