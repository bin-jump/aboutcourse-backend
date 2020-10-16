package com.aboutcourse.schedule.infrastructure.persistence.jpa;

import com.aboutcourse.schedule.domain.entity.Task;
import com.aboutcourse.schedule.domain.repository.TaskRepository;
import com.aboutcourse.schedule.infrastructure.persistence.jpa.repository.TaskJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    @Autowired
    TaskJpaRepository taskJpaRepository;

    @Override
    public Task create(Task task) {
        return taskJpaRepository.save(task);
    }
}
