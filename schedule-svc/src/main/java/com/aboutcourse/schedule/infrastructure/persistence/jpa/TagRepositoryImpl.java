package com.aboutcourse.schedule.infrastructure.persistence.jpa;

import com.aboutcourse.schedule.domain.entity.Tag;
import com.aboutcourse.schedule.domain.repository.TagRepository;
import com.aboutcourse.schedule.infrastructure.persistence.jpa.repository.TagJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TagRepositoryImpl implements TagRepository {

    @Autowired
    TagJpaRepository tagJpaRepository;

    @Override
    public List<Tag> findByNamePrefix(long uid, String prefix) {
        return tagJpaRepository.findTop10ByUserIdAndLabelStartsWith(uid, prefix);
    }

    @Override
    public List<Tag> findByNames(long uid, List<String> names) {
        return tagJpaRepository.findByUserIdAndLabelIn(uid, names);
    }
}
