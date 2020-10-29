package com.aboutcourse.course.domain.service;

import com.aboutcourse.course.domain.entity.Student;
import com.aboutcourse.course.domain.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    Student create(Long id, String name, Long schoolId, Long majorId) {
        Student student = Student.builder()
                .name(name)
                .schoolId(schoolId)
                .majorId(majorId)
                .build();
        student.setId(id);

        return studentRepository.create(student);
    }
}
