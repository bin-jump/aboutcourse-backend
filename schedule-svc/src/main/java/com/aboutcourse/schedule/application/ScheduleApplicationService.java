package com.aboutcourse.schedule.application;

import com.aboutcourse.common.api.BaseResponse;
import com.aboutcourse.course.client.CourseClient;
import com.aboutcourse.course.dto.GenericCourseResponse;
import com.aboutcourse.course.dto.LectureDto;
import com.aboutcourse.schedule.domain.service.ScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ScheduleApplicationService {

    @Autowired
    CourseClient courseClient;

    //@Autowired
    //ScheduleService scheduleService;

    public LectureDto createAndAddLecture(long uid, LectureDto lectureDto) {

        BaseResponse<LectureDto> res = courseClient.createLecture(lectureDto);
        //scheduleService.AddUserLecture(uid, res.getLectureDto().getId());
        log.error("createAndAddLecture: " + res.getDate().getId());
        return res.getDate();
    }

}
