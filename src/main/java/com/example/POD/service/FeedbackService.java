package com.example.POD.service;

import com.example.POD.entity.Feedback;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface FeedbackService {
    Iterable<Feedback> findAll();
    Optional<Feedback> findByFeedbackId(long feedbackId);
    Feedback save(Feedback feedback);
    void delete(long feedbackId);
}
