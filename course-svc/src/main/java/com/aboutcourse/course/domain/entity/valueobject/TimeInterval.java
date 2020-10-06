package com.aboutcourse.course.domain.entity.valueobject;

import com.aboutcourse.common.error.InvalidValueException;
import lombok.Getter;

import java.util.Date;

@Getter
public class TimeInterval {

    public TimeInterval(int d, Date s, Date e) {
        if (d < 0 || d > 6) {
            throw new InvalidValueException("day of time interval not valid");
        }
        if (e.before(s)) {
            throw new InvalidValueException("start and end time of time interval not valid");
        }

        day = d;
        start = s;
        end = e;
    }

    private int day;

    private Date start;

    private Date end;
}
