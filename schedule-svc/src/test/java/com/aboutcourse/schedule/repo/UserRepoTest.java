package com.aboutcourse.schedule.repo;

import com.aboutcourse.schedule.ScheduleApplication;
import com.aboutcourse.schedule.domain.entity.LectureItem;
import com.aboutcourse.schedule.domain.entity.Task;
import com.aboutcourse.schedule.domain.entity.User;
import com.aboutcourse.schedule.domain.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = ScheduleApplication.class, webEnvironment= SpringBootTest.WebEnvironment.MOCK)
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class UserRepoTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testCreate() {
        User user = new User();
        user.setName("test");

        user.addTask(Task.builder().title("title").build());
        user.addLecture(new LectureItem(1L, user));

        userRepository.create(user);

        user = userRepository.getById(user.getId());
        Assert.assertNotNull(user);
        Assert.assertTrue(user.getTasks().size() > 0);
        Assert.assertTrue(user.getLectures().size() > 0);

    }
}
