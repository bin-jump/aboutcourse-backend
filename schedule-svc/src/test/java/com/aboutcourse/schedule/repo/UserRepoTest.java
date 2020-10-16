package com.aboutcourse.schedule.repo;

import com.aboutcourse.schedule.ScheduleApplication;
import com.aboutcourse.schedule.domain.entity.LectureItem;
import com.aboutcourse.schedule.domain.entity.Tag;
import com.aboutcourse.schedule.domain.entity.Task;
import com.aboutcourse.schedule.domain.entity.User;
import com.aboutcourse.schedule.domain.entity.valueobject.RepeatType;
import com.aboutcourse.schedule.domain.repository.TagRepository;
import com.aboutcourse.schedule.domain.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@SpringBootTest(classes = ScheduleApplication.class, webEnvironment= SpringBootTest.WebEnvironment.MOCK)
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class UserRepoTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TagRepository tagRepository;

    @Test
    public void testCreate() {
        Instant inst = Instant.now();

        User user = User.builder()
                .name("user3")
                .school("school")
                .major("major")
                .build();

        Task task = Task.builder()
                .title("title")
                .startDate(Date.from(inst))
                .dueDate(Date.from(inst.plus(180, ChronoUnit.DAYS)))
                .startTime(Date.from(inst))
                .endTime(Date.from(inst.plus(1, ChronoUnit.HOURS)))
                .repeat(RepeatType.NONE)
                .build();

        user.addTask(task);
        user.addLecture(new LectureItem(1L, user));

        userRepository.create(user);

        user = userRepository.getById(user.getId());
        Assert.assertNotNull(user.getId());
        Tag t = new Tag(null, user.getId(), "java");
        task.setId(null);
        task.addTag(t);

        user.addTask(task);

        userRepository.update(user);

        List<Tag> tags = tagRepository.findByNamePrefix(user.getId(), "ja");

        Assert.assertTrue(user.getTasks().size() > 0);
        Assert.assertTrue(user.getLectures().size() > 0);

        Assert.assertTrue(tags.size() > 0);

    }
}
