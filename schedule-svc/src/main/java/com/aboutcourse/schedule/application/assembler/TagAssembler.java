package com.aboutcourse.schedule.application.assembler;

import com.aboutcourse.schedule.domain.entity.Tag;
import com.aboutcourse.schedule.dto.TagDto;

public class TagAssembler {

    public static TagDto toDto(Tag tag) {
        return TagDto.builder()
                .id(tag.getId())
                .label(tag.getLabel())
                .build();

    }
}
