package com.aboutcourse.schedule.domain.repository;

import com.aboutcourse.schedule.domain.entity.Tag;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository {

    List<Tag> findByNamePrefix(long uid, String prefix);

    List<Tag> findByNames(long uid, List<String> names);
}
