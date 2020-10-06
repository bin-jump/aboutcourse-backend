package com.aboutcourse.schedule.domain.repository;

import com.aboutcourse.schedule.domain.entity.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository {

    Task create(Task task);

    //List<Task> getByUser(long uid);

}
