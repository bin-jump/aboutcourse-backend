package com.aboutcourse.course.domain.entity;

import com.aboutcourse.common.shared.EntityBase;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Student extends EntityBase<Student> {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "avatar_url", nullable = false)
    private String avatarUrl;

    @Column(name = "school_id", nullable = false)
    private Long schoolId;

    @Column(name = "major_id", nullable = false)
    private Long majorId;
}
