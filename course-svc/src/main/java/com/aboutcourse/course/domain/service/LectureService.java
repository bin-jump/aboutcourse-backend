package com.aboutcourse.course.domain.service;

import com.aboutcourse.course.domain.entity.Lecture;
import com.aboutcourse.course.domain.repository.LectureRepository;
import com.aboutcourse.course.domain.repository.LectureSearchRepository;
import com.aboutcourse.course.domain.service.command.CreateLectureCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LectureService {

    @Autowired
    LectureRepository lectureRepository;

    @Autowired
    LectureSearchRepository lectureSearchRepository;

    public Lecture create(CreateLectureCommand command) {

        Lecture lecture = Lecture.builder()
                .title(command.getTitle())
                .startDate(command.getStartDate())
                .dueDate(command.getDueDate())
                .info(command.getInfo())
                .build();

        command.getIntervals().forEach(t -> {
            lecture.getIntervals().add(t);
        });

        lectureRepository.create(lecture);
        lectureSearchRepository.save(lecture);

        return lecture;
    }
}
