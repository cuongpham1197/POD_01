package com.example.POD.service.impl;

import com.example.POD.entity.Feedback;
import com.example.POD.repository.FeedbackRepository;
import com.example.POD.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public Iterable<Feedback> findAll(){ return feedbackRepository.findAll();}

    @Override
    public Optional<Feedback> findByFeedbackId(long feedbackId) {
        return feedbackRepository.findByFeedbackId(feedbackId);
    }

    @Override
    public Feedback save(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public void delete(long feedbackId){
        feedbackRepository.deleteByFeedbackId(feedbackId);
    }
}
