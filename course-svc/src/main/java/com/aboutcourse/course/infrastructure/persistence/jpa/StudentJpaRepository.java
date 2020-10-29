package com.aboutcourse.course.infrastructure.persistence.jpa;

import com.aboutcourse.course.domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentJpaRepository extends JpaRepository<Student, Long> {

    Student findByName(String name);
}
