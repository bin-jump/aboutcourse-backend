package com.aboutcourse.schedule.domain.entity;

import com.aboutcourse.common.shared.EntityBase;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tag extends EntityBase<Tag> {

    public Tag(){}

    public Tag(Long id, Long userId, String label) {
        this.id = id;
        this.userId = userId;
        this.label = label;
    }

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "label", nullable = false)
    private String label;

    public Long getUserId() {
        return userId;
    }

    public String getLabel() {
        return label;
    }

    @ManyToMany(mappedBy = "tags", cascade = CascadeType.PERSIST)
    private Set<Task> tasks = new HashSet<>();

    public Set<Task> getTasks() {
        return tasks;
    }
}
