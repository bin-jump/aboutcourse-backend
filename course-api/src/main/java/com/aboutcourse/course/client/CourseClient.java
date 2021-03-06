package com.aboutcourse.course.client;

import com.aboutcourse.common.api.BaseResponse;
import com.aboutcourse.course.dto.GenericCourseResponse;
import com.aboutcourse.course.dto.LectureDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "course-service", path = "/api/course", url = "localhost:8084")
public interface CourseClient {

    @PostMapping("/lecture")
    BaseResponse<LectureDto> createLecture(LectureDto lectureDto);

    @PostMapping("/lectures")
    BaseResponse<List<LectureDto>> getLectures(List<Long> ids);

    @GetMapping("/search")
    BaseResponse<List<LectureDto>> search(@RequestParam(value = "q") String searchKey,
                                          @RequestParam(value = "userId") Long userId);
}
