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
public class Comment extends EntityBase<Comment> {

    @Column(name = "review_id", nullable = false)
    private Long reviewId;

    @Column(name = "body", nullable = false)
    private String body;

    @Column(name = "created", nullable = false)
    @Builder.Default
    private Date created = new Date();

    @OneToOne
    @JoinColumn(name="student_id")
    private Student student;
}
