package com.aboutcourse.course.domain.service;

import com.aboutcourse.course.domain.entity.Lecture;
import com.aboutcourse.course.domain.repository.LectureRepository;
import com.aboutcourse.course.domain.service.command.CreateLectureCommand;
import org.springframework.beans.factory.annotation.Autowired;

public class LectureService {

    @Autowired
    LectureRepository lectureRepository;

    public Lecture createLecture(CreateLectureCommand command) {

        return null;
    }
}
