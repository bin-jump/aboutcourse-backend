package com.aboutcourse.course.domain.entity;

import com.aboutcourse.common.shared.EntityBase;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Major extends EntityBase<School> {

    @Column(name = "name")
    private String name;

    @Column(name = "info")
    private String info;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "school_id")
    private School school;
}
