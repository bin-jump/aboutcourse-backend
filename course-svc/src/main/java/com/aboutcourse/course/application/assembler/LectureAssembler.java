package com.aboutcourse.course.application.assembler;

import com.aboutcourse.course.domain.entity.Lecture;
import com.aboutcourse.course.domain.entity.valueobject.TimeInterval;
import com.aboutcourse.course.dto.LectureDto;
import com.aboutcourse.course.dto.TimeIntervalDto;

import java.util.Date;

public class LectureAssembler {

    public static LectureDto toDto(Lecture lecture) {

        LectureDto lectureDto = LectureDto.builder()
                .id(lecture.getId())
                .title(lecture.getTitle())
                .schoolId(lecture.getSchoolId())
                .majorId(lecture.getMajorId())
                .startDate(lecture.getStartDate().getTime())
                .dueDate(lecture.getDueDate().getTime())
                .info(lecture.getInfo())
                .build();

        lecture.getIntervals().forEach(t -> lectureDto.getIntervals().add(toDto(t)));
        return lectureDto;
    }

    public static TimeInterval toDO(TimeIntervalDto timeIntervalDto) {

        return new TimeInterval(timeIntervalDto.getDay(),
                new Date(timeIntervalDto.getStart()), new Date(timeIntervalDto.getEnd()));
    }

    public static TimeIntervalDto toDto(TimeInterval timeInterval) {

        return TimeIntervalDto.builder().day(timeInterval.getDay())
                .start(timeInterval.getStart().getTime())
                .end(timeInterval.getEnd().getTime())
                .build();
    }
}
