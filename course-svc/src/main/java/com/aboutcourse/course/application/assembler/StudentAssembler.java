package com.aboutcourse.course.application.assembler;

import com.aboutcourse.course.domain.entity.Student;
import com.aboutcourse.course.dto.StudentDto;

public class StudentAssembler {

    public static StudentDto toDto(Student student) {

        StudentDto studentDto = StudentDto.builder()
                .id(student.getId())
                .avatarUrl(student.getAvatarUrl())
                .name(student.getName())
                .majorId(student.getMajorId())
                .schoolId(student.getSchoolId())
                .build();

        return studentDto;
    }

}
