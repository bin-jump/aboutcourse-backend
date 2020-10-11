package com.aboutcourse.course.repo;

import com.aboutcourse.course.CourseApplication;
import com.aboutcourse.course.domain.entity.Lecture;
import com.aboutcourse.course.domain.entity.valueobject.TimeInterval;
import com.aboutcourse.course.domain.repository.LectureRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@SpringBootTest(classes = CourseApplication.class, webEnvironment= SpringBootTest.WebEnvironment.MOCK)
@RunWith(SpringRunner.class)
@Slf4j
public class LectureRepoTest {

    @Autowired
    LectureRepository lectureRepository;

    @Test
    public void testCreate() {
        Instant t = Instant.now();

        Lecture lecture = Lecture.builder()
                .title("lecture")
                .startDate(Date.from(t))
                .dueDate(Date.from(t.plus(180, ChronoUnit.DAYS)))
                .info("lecture info")
                .majorId(1L)
                .schoolId(1L)
                .build();

        TimeInterval interval = new TimeInterval(0, Date.from(t),
                Date.from(t.plus(1, ChronoUnit.HOURS)));
        lecture.addTimeInterval(interval);

        lectureRepository.create(lecture);

        lecture = lectureRepository.getById(lecture.getId());
        Assert.assertNotNull(lecture);
        Assert.assertTrue(lecture.getIntervals().size() > 0);
    }
}
