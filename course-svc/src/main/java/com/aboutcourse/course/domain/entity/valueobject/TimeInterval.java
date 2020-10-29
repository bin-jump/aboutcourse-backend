package com.aboutcourse.course.domain.entity.valueobject;

import com.aboutcourse.common.error.InvalidValueException;
import com.aboutcourse.common.shared.EntityBase;
import com.aboutcourse.common.util.Helper;
import com.aboutcourse.course.domain.entity.Lecture;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class TimeInterval extends EntityBase<TimeInterval> {

    public TimeInterval(int d, Date s, Date e) {
        if (d < 0 || d > 6) {
            throw new InvalidValueException("day of time interval not valid");
        }
        if (e.before(s)) {
            throw new InvalidValueException("start and end time of time interval not valid");
        }
        if (!(Helper.validTime(s) && Helper.validTime(e))) {
            throw new InvalidValueException("start or end time of time interval not valid");
        }

        day = d;
        start = Helper.timeOnly(s);
        end = Helper.timeOnly(e);
    }

    @Column(name = "day")
    private int day;

    @Column(name = "start")
    @Temporal(TemporalType.TIME)
    private Date start;

    @Column(name = "end")
    @Temporal(TemporalType.TIME)
    private Date end;

    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;
}
