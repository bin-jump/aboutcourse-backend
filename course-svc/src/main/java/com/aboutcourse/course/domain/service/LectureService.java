package com.aboutcourse.course.domain.service;

import com.aboutcourse.common.error.InvalidValueException;
import com.aboutcourse.common.error.ResourceNotFoundException;
import com.aboutcourse.common.util.Helper;
import com.aboutcourse.course.domain.entity.Lecture;
import com.aboutcourse.course.domain.entity.Student;
import com.aboutcourse.course.domain.repository.LectureRepository;
import com.aboutcourse.course.domain.repository.LectureSearchRepository;
import com.aboutcourse.course.domain.repository.StudentRepository;
import com.aboutcourse.course.domain.service.command.CreateLectureCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LectureService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    LectureRepository lectureRepository;

    @Autowired
    LectureSearchRepository lectureSearchRepository;

    public Lecture create(CreateLectureCommand command) {
        Student student = studentRepository.getById(command.getStudentId());
        if (student == null) {
            throw new ResourceNotFoundException("student not exist");
        }

        Lecture lecture = Lecture.builder()
                .schoolId(student.getSchoolId())
                .majorId(student.getMajorId())
                .title(command.getTitle())
                .startDate(Helper.dateOnly(command.getStartDate()))
                .dueDate(Helper.dateOnly(command.getDueDate()))
                .info(command.getInfo())
                .build();

        command.getIntervals().forEach(t -> {
            lecture.addTimeInterval(t);
        });
        validate(lecture);

        lectureRepository.create(lecture);
        lectureSearchRepository.save(lecture);

        return lecture;
    }

    private void validate(Lecture lecture) {
        if (lecture.getIntervals().size() == 0) {
            throw new InvalidValueException("lecture has not time interval");
        }
    }
}
