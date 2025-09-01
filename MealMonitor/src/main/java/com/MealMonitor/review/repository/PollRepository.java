package com.MealMonitor.review.repository;

import com.MealMonitor.review.entity.Poll;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PollRepository extends MongoRepository<Poll, String> {
    
    List<Poll> findByReviewId(String reviewId);
    
    List<Poll> findByUserId(Long userId);
    
    List<Poll> findByReviewIdAndUserId(String reviewId, Long userId);
}
