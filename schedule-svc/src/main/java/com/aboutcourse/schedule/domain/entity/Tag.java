package com.aboutcourse.schedule.domain.entity;

import com.aboutcourse.common.shared.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Tag extends Entity<Tag> {

    public Tag(Long id, long userId, String label) {
        this.id = id;
        this.userId = userId;
        this.label = label;
    }

    private long userId;

    private String label;
}
