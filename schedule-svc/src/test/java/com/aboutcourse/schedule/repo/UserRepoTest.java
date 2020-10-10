package com.aboutcourse.schedule.repo;

import com.aboutcourse.schedule.ScheduleApplication;
import com.aboutcourse.schedule.domain.entity.LectureItem;
import com.aboutcourse.schedule.domain.entity.Tag;
import com.aboutcourse.schedule.domain.entity.Task;
import com.aboutcourse.schedule.domain.entity.User;
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
        User user = new User();
        user.setName("test");

        Task task = Task.builder().title("title").build();

        user.addTask(task);
        user.addLecture(new LectureItem(1L, user));

        userRepository.create(user);

        user = userRepository.getById(user.getId());
        Assert.assertNotNull(user.getId());

        task = Task.builder().title("task2").build();
        Tag t = new Tag(null, user.getId(), "tag");
        task.addTag(t);

//        t = new Tag(null, user.getId(), "tag2");
//        task.addTag(t);
        user.addTask(task);

        userRepository.update(user);

        List<Tag> tags = tagRepository.findByNamePrefix(user.getId(), "ta");

        Assert.assertTrue(user.getTasks().size() > 0);
        Assert.assertTrue(user.getLectures().size() > 0);

        Assert.assertTrue(tags.size() > 0);

    }
}
