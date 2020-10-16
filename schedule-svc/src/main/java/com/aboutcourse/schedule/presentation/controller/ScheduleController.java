package com.aboutcourse.schedule.presentation.controller;

import com.aboutcourse.common.api.BaseResponse;
import com.aboutcourse.common.auth.AuthContext;
import com.aboutcourse.course.dto.LectureDto;
import com.aboutcourse.schedule.application.ScheduleApplicationService;
import com.aboutcourse.schedule.domain.service.ScheduleService;
import com.aboutcourse.schedule.dto.TaskDto;
import com.aboutcourse.schedule.dto.TaskItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/schedule")
@Validated
public class ScheduleController {



    @Autowired
    ScheduleApplicationService scheduleApplicationService;

    @PostMapping("task")
    public BaseResponse<TaskDto> create(@RequestBody TaskDto taskDto) {
        Long userId = AuthContext.getUserId();
        taskDto = scheduleApplicationService.createTask(userId, taskDto);

        return new BaseResponse<>(taskDto);
    }


    @GetMapping("my-schedule")
    public BaseResponse<List<TaskItemDto>> getAll() {
        Long userId = AuthContext.getUserId();
        List<TaskItemDto> res = scheduleApplicationService.getUserSchedule(userId);

        return new BaseResponse<>(res);
    }

    @DeleteMapping("task/{id}")
    public BaseResponse remove(@PathVariable Long id) {
        Long userId = AuthContext.getUserId();
        scheduleApplicationService.removeTask(userId, id);

        return new BaseResponse();
    }


}
