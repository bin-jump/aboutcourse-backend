package com.aboutcourse.schedule.application;

import com.aboutcourse.common.api.BaseResponse;
import com.aboutcourse.common.error.ResourceNotFoundException;
import com.aboutcourse.course.client.CourseClient;
import com.aboutcourse.course.dto.LectureDto;
import com.aboutcourse.schedule.application.assembler.TaskAssembler;
import com.aboutcourse.schedule.domain.entity.LectureItem;
import com.aboutcourse.schedule.domain.entity.Tag;
import com.aboutcourse.schedule.domain.entity.Task;
import com.aboutcourse.schedule.domain.entity.User;
import com.aboutcourse.schedule.domain.entity.valueobject.RepeatType;
import com.aboutcourse.schedule.domain.repository.UserRepository;
import com.aboutcourse.schedule.domain.service.ScheduleService;
import com.aboutcourse.schedule.domain.service.command.CreateTaskCommand;
import com.aboutcourse.schedule.dto.TaskDto;
import com.aboutcourse.schedule.dto.TaskItemDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.tools.asm.Assembler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ScheduleApplicationService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CourseClient courseClient;

    @Autowired
    ScheduleService scheduleService;

    public List<TaskItemDto> getUserSchedule(Long id) {
        User user = userRepository.getById(id);
        if (user == null) {
            throw new ResourceNotFoundException(String.format("user with id: %d not found", id));
        }
        List<LectureDto> lectureDtos = courseClient
                .getLectures(user.getLectures().stream()
                        .map(LectureItem::getLectureId).collect(Collectors.toList())).getData();
        List<TaskDto> taskDtos = user.getTasks().stream()
                .map(TaskAssembler::toDto).collect(Collectors.toList());

        List<TaskItemDto> res = new ArrayList<>();
        lectureDtos.forEach(l ->
                res.add(new TaskItemDto<LectureDto>(TaskItemDto.TaskType.LECTURE, l)));
        taskDtos.forEach(t ->
                res.add(new TaskItemDto<TaskDto>(TaskItemDto.TaskType.TASK, t)));

        return res;
    }

    @Transactional
    public LectureDto createAndAddLecture(Long uid, LectureDto lectureDto) {

        BaseResponse<LectureDto> res = courseClient.createLecture(lectureDto);
        scheduleService.addUserLecture(uid, res.getData().getId());

        return res.getData();
    }

    @Transactional
    public TaskDto createTask(Long uid, TaskDto taskDto) {

        CreateTaskCommand command = CreateTaskCommand
                .builder()
                .userId(uid)
                .title(taskDto.getTitle())
                .startDate(new Date(taskDto.getStartDate()))
                .dueDate(new Date(taskDto.getDueDate()))
                .startTime(new Date(taskDto.getStartTime()))
                .endTime(new Date(taskDto.getEndTime()))
                .period(taskDto.isPeriod())
                .repeat(RepeatType.valueOf(taskDto.getRepeat()))
                .info(taskDto.getInfo())
                .build();


        taskDto.getTags().forEach(t -> {
            CreateTaskCommand.TagItem tag = new CreateTaskCommand.TagItem(t.getId(), t.getLabel());
            command.getTags().add(tag);
        });

        Task task = scheduleService.createTask(command);
        return TaskAssembler.toDto(task);
    }

    @Transactional
    public void removeTask(Long uid, Long id) {
        scheduleService.removeTask(uid, id);
    }


}
