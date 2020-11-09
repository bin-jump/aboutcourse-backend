package com.aboutcourse.course.domain.entity;

import com.aboutcourse.common.shared.EntityBase;
import lombok.*;

import javax.persistence.*;
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

    @OneToMany(mappedBy = "school", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<Major> majors = new HashSet<>();

    public void addMajor(Major major) {
        for (Major m : getMajors()) {
            if (m.getName().equals(major.getName())) {
                return;
            }
        }
        major.setSchool(this);
        majors.add(major);
    }

}
