package com.example.POD.repository;

import com.example.POD.entity.Feedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Integer> {
    Optional<Feedback> findByFeedbackId(long feedbackId);
    Iterable<Feedback> findAll();
    void deleteByFeedbackId(long feedbackId);
}
