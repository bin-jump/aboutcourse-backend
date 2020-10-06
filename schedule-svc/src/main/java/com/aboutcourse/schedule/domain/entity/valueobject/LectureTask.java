package com.aboutcourse.schedule.domain.entity.valueobject;

import com.aboutcourse.common.shared.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LectureTask extends ValueObject<LectureTask> {

    private long userId;

    private long lectureId;

    @Override
    protected List<Object> getEquityProperty() {
        return Arrays.asList(userId, lectureId);
    }
}
