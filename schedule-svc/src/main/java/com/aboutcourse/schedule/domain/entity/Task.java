package com.aboutcourse.schedule.domain.entity;

import com.aboutcourse.common.shared.EntityBase;
import com.aboutcourse.schedule.domain.entity.valueobject.RepeatType;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(
        indexes = {
                @Index(columnList = "user_id")
        },
        uniqueConstraints={
                @UniqueConstraint(columnNames = {"id", "title"})
        }
)
public class Task extends EntityBase<Task> {

//    @Column(name = "user_id")
//    private Long userId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "due_date", nullable = false)
    private Date dueDate;

    @Column(name = "start_time", nullable = false)
    private Date startTime;

    @Column(name = "end_time", nullable = false)
    private Date endTime;

    @Column(name = "period", nullable = false)
    private boolean period;

    @Column(name = "repeat_type", nullable = false)
    private RepeatType repeat = RepeatType.NONE;

    @Column(name = "info")
    private String info;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "task_tag",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    @Builder.Default
    private Set<Tag> tags = new HashSet<>();

    public void addTag(Tag tag) {
        tag.getTasks().add(this);
        tags.add(tag);
    }

}
