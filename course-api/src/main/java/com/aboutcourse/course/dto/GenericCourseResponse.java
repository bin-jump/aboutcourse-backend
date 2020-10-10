package com.aboutcourse.course.dto;

import com.aboutcourse.common.api.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenericCourseResponse extends BaseResponse {

    private LectureDto lectureDto;
}
