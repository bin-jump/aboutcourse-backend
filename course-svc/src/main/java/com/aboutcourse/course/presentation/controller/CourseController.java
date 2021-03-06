package com.aboutcourse.course.presentation.controller;

import com.aboutcourse.common.api.BasePageResponse;
import com.aboutcourse.common.api.BaseResponse;
import com.aboutcourse.common.auth.AuthContext;
import com.aboutcourse.common.error.ResourceNotFoundException;
import com.aboutcourse.common.service.PageResult;
import com.aboutcourse.course.application.CourseApplicationService;
import com.aboutcourse.course.application.assembler.LectureAssembler;
import com.aboutcourse.course.application.assembler.MajorAssembler;
import com.aboutcourse.course.application.assembler.SchoolAssembler;
import com.aboutcourse.course.domain.entity.Lecture;
import com.aboutcourse.course.domain.entity.Major;
import com.aboutcourse.course.domain.entity.School;
import com.aboutcourse.course.domain.entity.Student;
import com.aboutcourse.course.domain.repository.LectureRepository;
import com.aboutcourse.course.domain.repository.LectureSearchRepository;
import com.aboutcourse.course.domain.repository.SchoolRepository;
import com.aboutcourse.course.domain.repository.StudentRepository;
import com.aboutcourse.course.domain.service.command.CreateLectureCommand;
import com.aboutcourse.course.dto.LectureDto;
import com.aboutcourse.course.dto.MajorDto;
import com.aboutcourse.course.dto.SchoolDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/course")
@Validated
public class CourseController {

    @Autowired
    CourseApplicationService courseApplicationService;

    @Autowired
    LectureRepository lectureRepository;

    @Autowired
    LectureSearchRepository lectureSearchRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SchoolRepository schoolRepository;

    @PostMapping("lecture")
    public BaseResponse<LectureDto> create(@RequestBody LectureDto lectureDto) {

        CreateLectureCommand command = CreateLectureCommand.builder()
                .studentId(AuthContext.getUserId())
                .title(lectureDto.getTitle())
                .startDate(new Date(lectureDto.getStartDate()))
                .dueDate(new Date(lectureDto.getDueDate()))
                .info(lectureDto.getInfo())
                .build();

        lectureDto.getIntervals().forEach(t -> command.getIntervals().add(LectureAssembler.toDO(t)));
        lectureDto = courseApplicationService.createLecture(command);

        return new BaseResponse<>(lectureDto);
    }

    @PostMapping("lectures")
    public BaseResponse<List<LectureDto>> getLectures(@RequestBody List<Long> ids) {
        List<Lecture> lectures = lectureRepository.getByIds(ids);
        List<LectureDto> lectureDtos = lectures
                .stream().map(LectureAssembler::toDto).collect(Collectors.toList());

        return new BaseResponse<>(lectureDtos);
    }

    @GetMapping("search")
    public BaseResponse<List<LectureDto>> searchLectures(@RequestParam(value = "q") String searchKey,
                                                       @RequestParam(value = "userId") Long userId) {
        if (StringUtils.isEmpty(searchKey)) {
            return new BaseResponse<>(new ArrayList<>());
        }
        Student student = studentRepository.getById(userId);

        List<Lecture> lectures = lectureSearchRepository
                .search(searchKey, student.getSchoolId(), student.getMajorId());
        List<LectureDto> res = lectures
                .stream().map(LectureAssembler::toDto).collect(Collectors.toList());

        return new BaseResponse<>(res);
    }

    @GetMapping("lectures")
    public BasePageResponse<List<LectureDto>> listLectures(@RequestParam(value = "schoolId", required = false) Long schoolId,
                                                           @RequestParam(value = "majorId", required = false) Long majorId,
                                                           @RequestParam(value = "page", defaultValue = "0") int page) {
        PageResult<Lecture> res = lectureRepository
                .getBySchoolMajor(schoolId, majorId, page, 10);

        List<LectureDto> lectureDtos = res.getData().stream()
                .map(LectureAssembler::toDto).collect(Collectors.toList());

        return new BasePageResponse<>(lectureDtos, res.hasMore(), res.getPageNumber());

    }

    @GetMapping("schools")
    public BaseResponse<List<SchoolDto>> listSchools() {

        List<School> schools = schoolRepository.getAll();
        List<SchoolDto> schoolDtos = schools.stream()
                .map(SchoolAssembler::toDto).collect(Collectors.toList());

        return new BaseResponse<>(schoolDtos);

    }

    @GetMapping("school/{id}/majors")
    public BaseResponse<List<MajorDto>> listMajors(@PathVariable Long id) {

        School school = schoolRepository.getById(id);
        if (school == null) {
            throw new ResourceNotFoundException("school not found");
        }
        List<MajorDto> majorDtos = new ArrayList<>(school.getMajors())
                .stream().map(MajorAssembler::toDto).collect(Collectors.toList());

        return new BaseResponse<>(majorDtos);

    }
}
