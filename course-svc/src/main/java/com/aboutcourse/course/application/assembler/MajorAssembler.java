package com.aboutcourse.course.application.assembler;

import com.aboutcourse.course.domain.entity.Major;
import com.aboutcourse.course.dto.MajorDto;

public class MajorAssembler {

    public static MajorDto toDto(Major major) {
        MajorDto majorDto = MajorDto.builder()
                .id(major.getId())
                .name(major.getName())
                .info(major.getInfo())
                .build();

        return majorDto;
    }
}
