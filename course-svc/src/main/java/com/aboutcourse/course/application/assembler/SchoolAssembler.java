package com.aboutcourse.course.application.assembler;

import com.aboutcourse.course.domain.entity.School;
import com.aboutcourse.course.dto.SchoolDto;

public class SchoolAssembler {

    public static SchoolDto toDto(School school) {

        SchoolDto schoolDto = SchoolDto.builder()
                .id(school.getId())
                .info(school.getInfo())
                .name(school.getName())
                .build();

        return schoolDto;
    }
}
