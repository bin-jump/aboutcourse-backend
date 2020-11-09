package com.aboutcourse.course.domain.service;

import com.aboutcourse.common.error.ResourceNotFoundException;
import com.aboutcourse.course.domain.entity.Comment;
import com.aboutcourse.course.domain.entity.Lecture;
import com.aboutcourse.course.domain.entity.Review;
import com.aboutcourse.course.domain.entity.Student;
import com.aboutcourse.course.domain.repository.LectureRepository;
import com.aboutcourse.course.domain.repository.ReviewRepository;
import com.aboutcourse.course.domain.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    LectureRepository lectureRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    StudentRepository studentRepository;


    public Review createReview(Long studentId, Long lectureId, String body, int score) {
        Student student = studentRepository.getById(studentId);
        if (student == null) {
            throw new ResourceNotFoundException("student not exist");
        }
        Lecture lecture = lectureRepository.getById(lectureId);
        if (lecture == null) {
            throw new ResourceNotFoundException("lecture not exist");
        }

        lecture.newScore(score);
        Review review = Review.builder()
                .lectureId(lectureId)
                .body(body)
                .courseScore(score)
                .student(student)
                .build();

        lectureRepository.update(lecture);
        reviewRepository.create(review);
        return review;
    }

    public Comment createComment(Long studentId, Long reviewId, String body) {
        Student student = studentRepository.getById(studentId);
        if (student == null) {
            throw new ResourceNotFoundException("student not exist");
        }

        Comment comment = Comment.builder()
                .body(body)
                .reviewId(reviewId)
                .student(student)
                .build();

        return reviewRepository.createComment(comment);
    }


}
