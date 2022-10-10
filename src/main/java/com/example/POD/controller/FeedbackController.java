package com.example.POD.controller;

import com.example.POD.entity.Feedback;
import com.example.POD.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api1")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/feedback/all")
    public ResponseEntity<Iterable<Feedback>> getAll() {
        return new ResponseEntity<>(feedbackService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/feedback/{feedbackId}")
    public ResponseEntity<Feedback> getFeedbackByFeedbackId(@RequestParam long feedbackId) {
        Optional<Feedback> feedbackOptional = feedbackService.findByFeedbackId(feedbackId);
        return feedbackOptional.map(feedback -> new ResponseEntity<>(feedback, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/feedback/post")
    public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback feedback) {
        return new ResponseEntity<>(feedbackService.save(feedback), HttpStatus.OK);
    }

    @PutMapping("/feedback/{feedbackId}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable long feedbackId, @RequestBody Feedback feedback) {
        Optional<Feedback> feedbackOptional = feedbackService.findByFeedbackId(feedbackId);
        return feedbackOptional.map(feedback1 -> {
            feedback.setFeedbackId(feedback1.getFeedbackId());
            return new ResponseEntity<>(feedbackService.save(feedback), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/feedback/{id}")
    public ResponseEntity<Feedback> deleteFeedback(@PathVariable long feedbackId) {
        Optional<Feedback> feedbackOptional = feedbackService.findByFeedbackId(feedbackId);
        return feedbackOptional.map(feedback -> {
            feedbackService.delete(feedbackId);
            return new ResponseEntity<>(feedback, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
