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
        }
)
public class Task extends EntityBase<Task> {

//    @Column(name = "user_id")
//    private Long userId;

    @Column(name = "title")
    private String title;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    @Column(name = "period")
    private boolean period;

    @Column(name = "repeat_type")
    private RepeatType repeat = RepeatType.NONE;

    @Column(name = "info")
    private String info;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "task_tag",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    @Builder.Default
    private Set<Tag> tags = new HashSet<>();



}
