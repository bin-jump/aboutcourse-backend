package com.aboutcourse.schedule.presentation.controller;

import com.aboutcourse.course.dto.LectureDto;
import com.aboutcourse.schedule.application.ScheduleApplicationService;
import com.aboutcourse.schedule.domain.service.ScheduleService;
import com.aboutcourse.schedule.dto.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/schedule")
@Validated
public class ScheduleController {

    @Autowired
    ScheduleApplicationService scheduleApplicationService;

    @PostMapping("task")
    public TaskDto create(TaskDto taskDto) {

        taskDto.setId(1L);
        return taskDto;
    }


    @GetMapping
    public List<Object> getAll() {

        List<Object> res = new ArrayList<>();

        return res;
    }

    @GetMapping("test")
    public String test() {

        scheduleApplicationService.createAndAddLecture(1L, LectureDto.builder()
                .id(22L)
                .build());
        return "sch test";
    }

}
