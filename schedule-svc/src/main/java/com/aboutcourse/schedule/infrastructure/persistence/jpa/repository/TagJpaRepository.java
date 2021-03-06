package com.aboutcourse.schedule.infrastructure.persistence.jpa.repository;

import com.aboutcourse.schedule.domain.entity.Tag;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TagJpaRepository extends CrudRepository<Tag, Long> {

    List<Tag> findTop10ByUserIdAndLabelStartsWith(Long uid, String prefix);

    List<Tag> findByUserIdAndLabelIn(Long uid, List<String> names);
}
