package com.aboutcourse.schedule.domain.entity;

import com.aboutcourse.common.shared.EntityBase;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        uniqueConstraints={
                @UniqueConstraint(columnNames = {"user_id", "label"})
        }
)
public class Tag extends EntityBase<Tag> {

    public Tag(Long id, Long userId, String label) {
        this.id = id;
        this.userId = userId;
        this.label = label;
    }

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "label", nullable = false)
    private String label;

    @ManyToMany(mappedBy = "tags", cascade = CascadeType.PERSIST)
    private Set<Task> tasks = new HashSet<>();

    @Override
    public String toString() {
        return super.toString();
    }
}
