package com.aboutcourse.schedule.presentation.controller;

import com.aboutcourse.schedule.dto.LectureDto;
import com.aboutcourse.schedule.dto.TaskDto;
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

    @PostMapping("task")
    public TaskDto create(TaskDto taskDto) {

        taskDto.setId(1L);
        return taskDto;
    }

    @PostMapping("lecture")
    public LectureDto create(LectureDto lectureDto) {

        lectureDto.setId(1L);
        return lectureDto;
    }

    @GetMapping
    public List<Object> getAll() {

        List<Object> res = new ArrayList<Object>();

        return res;
    }

    @GetMapping("ts")
    public String test() {
        return "sch";
    }


}
