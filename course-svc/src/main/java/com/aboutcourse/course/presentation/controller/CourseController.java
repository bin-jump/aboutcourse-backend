package com.aboutcourse.course.presentation.controller;

import com.aboutcourse.common.api.BaseResponse;
import com.aboutcourse.course.application.CourseApplicationService;
import com.aboutcourse.course.application.assembler.LectureAssembler;
import com.aboutcourse.course.domain.service.command.CreateLectureCommand;
import com.aboutcourse.course.dto.LectureDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/course")
@Validated
public class CourseController {

    @Autowired
    CourseApplicationService courseApplicationService;

    @PostMapping("lecture")
    public BaseResponse<LectureDto> create(@RequestBody LectureDto lectureDto) {
        log.error("create lecture");

        CreateLectureCommand command = CreateLectureCommand.builder()
                .title(lectureDto.getTitle())
                .startDate(new Date(lectureDto.getStartDate()))
                .dueDate(new Date(lectureDto.getDueDate()))
                .info(lectureDto.getInfo())
                .build();

        lectureDto.getIntervals().forEach(t -> command.getIntervals().add(LectureAssembler.toDO(t)));
        lectureDto = courseApplicationService.createLecture(command);

        return new BaseResponse<>(lectureDto);
    }

    @GetMapping("search")
    public List<LectureDto> searchCourse(@RequestParam(value = "s") String schoolName,
                                         @RequestParam(value = "m") String majorName,
                                         @RequestParam(value = "q") String searchKey) {

        return null;
    }

}
