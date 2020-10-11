package com.aboutcourse.schedule.domain.entity;

import com.aboutcourse.common.shared.EntityBase;
import com.aboutcourse.common.shared.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LectureItem extends EntityBase<LectureItem> {

    @Column(name = "lecture_id", nullable = false)
    private Long lectureId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

}
