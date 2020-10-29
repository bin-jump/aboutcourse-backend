package com.aboutcourse.course.repo;

import com.aboutcourse.course.CourseApplication;
import com.aboutcourse.course.domain.entity.Student;
import com.aboutcourse.course.domain.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = CourseApplication.class, webEnvironment= SpringBootTest.WebEnvironment.MOCK)
@RunWith(SpringRunner.class)
@Slf4j
public class StudentRepoTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void testCreate() {
        Student student = Student.builder()
                .name("test")
                .schoolId(1L)
                .majorId(1L)
                .build();
        student.setId(1L);

        student = studentRepository.create(student);

        Assert.assertNotNull(student);
    }
}
