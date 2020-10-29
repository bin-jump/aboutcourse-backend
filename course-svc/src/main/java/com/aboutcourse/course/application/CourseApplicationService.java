package com.aboutcourse.course.application;

import com.aboutcourse.course.application.assembler.LectureAssembler;
import com.aboutcourse.course.domain.entity.Lecture;
import com.aboutcourse.course.domain.service.LectureService;
import com.aboutcourse.course.domain.service.command.CreateLectureCommand;
import com.aboutcourse.course.dto.LectureDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseApplicationService {

    @Autowired
    LectureService lectureService;

    @Transactional
    public LectureDto createLecture(CreateLectureCommand command) {

        Lecture lecture = lectureService.create(command);
        return LectureAssembler.toDto(lecture);
    }
}
