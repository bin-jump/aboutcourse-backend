package com.aboutcourse.course.domain.entity;

import com.aboutcourse.common.shared.EntityBase;
import com.aboutcourse.course.domain.entity.valueobject.CommentType;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Review extends EntityBase<Review> {

    @Column(name = "lecture_id", nullable = false)
    private Long lectureId;

    @Column(name = "body")
    private String body;

    @Column(name = "course_score", nullable = false)
    private Integer courseScore;

    @Column(name = "created", nullable = false)
    @Builder.Default
    private Date created = new Date();

    @OneToOne
    @JoinColumn(name="student_id")
    private Student student;

}
