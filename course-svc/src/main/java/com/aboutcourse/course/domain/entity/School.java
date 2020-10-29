package com.aboutcourse.course.domain.entity;

import com.aboutcourse.common.shared.EntityBase;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class School extends EntityBase<School> {

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "info")
    private String info;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<Major> majors = new HashSet<>();
}
