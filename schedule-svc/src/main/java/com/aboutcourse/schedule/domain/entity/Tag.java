package com.aboutcourse.schedule.domain.entity;

import com.aboutcourse.common.shared.EntityBase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Tag extends EntityBase<Tag> {

    public Tag(Long id, long userId, String label) {
        this.id = id;
        this.userId = userId;
        this.label = label;
    }

    @Column(name = "user_id")
    private long userId;

    @Column(name = "label")
    private String label;

    @ManyToMany(mappedBy = "tags")
    private Set<Task> tasks = new HashSet<>();
}
