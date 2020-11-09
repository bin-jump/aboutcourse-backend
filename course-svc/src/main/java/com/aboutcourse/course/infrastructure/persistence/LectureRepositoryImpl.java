package com.aboutcourse.course.infrastructure.persistence;


import com.aboutcourse.common.service.PageResult;
import com.aboutcourse.course.domain.entity.Comment;
import com.aboutcourse.course.domain.entity.Lecture;
import com.aboutcourse.course.domain.repository.LectureRepository;
import com.aboutcourse.course.infrastructure.persistence.jpa.LectureJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LectureRepositoryImpl implements LectureRepository {

    @Autowired
    LectureJpaRepository lectureJpaRepository;

    @Override
    public Lecture create(Lecture lecture) {
        return lectureJpaRepository.save(lecture);
    }

    @Override
    public void update(Lecture lecture) {
        lectureJpaRepository.save(lecture);
    }

    @Override
    public Lecture getById(Long id) {
        return lectureJpaRepository.findById(id).get();
    }

    @Override
    public List<Lecture> getByIds(List<Long> ids) {
        return lectureJpaRepository.findAllById(ids);
    }

    @Override
    public PageResult<Lecture> getBySchoolMajor(Long schoolId, Long majorId,
                                                int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<Lecture> paged = lectureJpaRepository.findBySchoolMajor(schoolId, majorId, paging);

        return PageResult.<Lecture>builder()
                .data(paged.getContent())
                .total(paged.getTotalElements())
                .totalPage(paged.getTotalPages())
                .pageNumber(paged.getNumber())
                .build();
    }
}
