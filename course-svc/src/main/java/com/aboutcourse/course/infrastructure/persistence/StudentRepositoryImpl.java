package com.aboutcourse.course.infrastructure.persistence;

import com.aboutcourse.course.domain.entity.Student;
import com.aboutcourse.course.domain.repository.StudentRepository;
import com.aboutcourse.course.infrastructure.persistence.jpa.StudentJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @Autowired
    StudentJpaRepository studentJpaRepository;

    @Override
    public Student create(Student student) {
        return studentJpaRepository.save(student);
    }

    @Override
    public Student getByName(String name) {
        return studentJpaRepository.findByName(name);
    }

    @Override
    public Student getById(Long id) {
        return studentJpaRepository.findById(id).orElse(null);
    }
}
