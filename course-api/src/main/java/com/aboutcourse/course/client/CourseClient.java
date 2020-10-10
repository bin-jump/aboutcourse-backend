package com.aboutcourse.course.client;

import com.aboutcourse.common.api.BaseResponse;
import com.aboutcourse.course.dto.GenericCourseResponse;
import com.aboutcourse.course.dto.LectureDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "course-service", path = "/api/course", url = "localhost:8084")
public interface CourseClient {

    @PostMapping("/lecture")
    BaseResponse<LectureDto> createLecture(LectureDto lectureDto);
}
