package com.aboutcourse.course.repo;

import com.aboutcourse.course.CourseApplication;
import com.aboutcourse.course.domain.entity.Major;
import com.aboutcourse.course.domain.entity.School;
import com.aboutcourse.course.domain.repository.SchoolRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = CourseApplication.class, webEnvironment= SpringBootTest.WebEnvironment.MOCK)
@RunWith(SpringRunner.class)
@Slf4j
public class SchoolRepoTest {

    @Autowired
    SchoolRepository schoolRepository;

    @Test
    public void testCreate () {

        School school = School.builder()
                .name("test school")
                .info("information of test school")
                .build();

        school = schoolRepository.create(school);

        Assert.assertNotNull(school);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testCreateMajor () {

        School school = schoolRepository.getById(1L);
        //school.getMajors();

        Major major = Major.builder()
                .name("test major")
                .info("information of test major")
                .build();
        school.addMajor(major);

        school = schoolRepository.update(school);

        Assert.assertNotNull(school.getMajors()
                .stream().filter(m -> m.getName().equals(major.getName())).findAny());
    }


}
