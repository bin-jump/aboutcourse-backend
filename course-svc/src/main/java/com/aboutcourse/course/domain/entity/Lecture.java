package com.aboutcourse.course.domain.entity;

import com.aboutcourse.common.shared.EntityBase;
import com.aboutcourse.course.domain.entity.valueobject.TimeInterval;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Lecture extends EntityBase<Lecture> {

    @Column(name = "school_id", nullable = false)
    private Long schoolId;

    @Column(name = "major_id", nullable = false)
    private Long majorId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "due_date", nullable = false)
    private Date dueDate;

    @Column(name = "info")
    private String info;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "lecture",
            cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<TimeInterval> intervals = new HashSet<>();

    public void addTimeInterval(TimeInterval interval) {
        interval.setLecture(this);
        this.intervals.add(interval);
    }

}
