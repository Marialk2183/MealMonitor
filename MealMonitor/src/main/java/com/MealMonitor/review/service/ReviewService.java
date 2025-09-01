package com.MealMonitor.review.service;

import com.MealMonitor.review.entity.Review;
import com.MealMonitor.review.entity.Poll;
import com.MealMonitor.review.entity.VoteType;
import com.MealMonitor.review.dto.ReviewDto;
import com.MealMonitor.review.repository.ReviewRepository;
import com.MealMonitor.review.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    
    @Autowired
    private ReviewRepository reviewRepository;
    
    @Autowired
    private PollRepository pollRepository;
    
    public Review createReview(ReviewDto reviewDto) {
        Review review = new Review();
        review.setUserId(reviewDto.getUserId());
        review.setFoodItem(reviewDto.getFoodItem());
        review.setDescription(reviewDto.getDescription());
        review.setImageUrl(reviewDto.getImageUrl());
        review.setRating(reviewDto.getRating());
        review.setIsAnonymous(reviewDto.getIsAnonymous());
        review.setCategory(reviewDto.getCategory());
        review.setCanteenLocation(reviewDto.getCanteenLocation());
        review.setCreatedAt(LocalDateTime.now());
        review.setUpdatedAt(LocalDateTime.now());
        
        return reviewRepository.save(review);
    }
    
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }
    
    public Optional<Review> getReviewById(String id) {
        return reviewRepository.findById(id);
    }
    
    public List<Review> getReviewsByUserId(Long userId) {
        return reviewRepository.findByUserId(userId);
    }
    
    public List<Review> getFlaggedReviews() {
        return reviewRepository.findByIsFlaggedTrue();
    }
    
    public Review flagReview(String reviewId, String flagReason) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new RuntimeException("Review not found"));
        
        review.setIsFlagged(true);
        review.setFlagReason(flagReason);
        review.setUpdatedAt(LocalDateTime.now());
        
        return reviewRepository.save(review);
    }
    
    public Review updateReview(String reviewId, ReviewDto reviewDto) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new RuntimeException("Review not found"));
        
        review.setFoodItem(reviewDto.getFoodItem());
        review.setDescription(reviewDto.getDescription());
        review.setImageUrl(reviewDto.getImageUrl());
        review.setRating(reviewDto.getRating());
        review.setCategory(reviewDto.getCategory());
        review.setCanteenLocation(reviewDto.getCanteenLocation());
        review.setUpdatedAt(LocalDateTime.now());
        
        return reviewRepository.save(review);
    }
    
    public void deleteReview(String reviewId) {
        reviewRepository.deleteById(reviewId);
    }
    
    public Poll createPoll(String reviewId, Long userId, VoteType voteType) {
        Poll poll = new Poll(reviewId, userId, voteType);
        return pollRepository.save(poll);
    }
    
    public List<Poll> getPollsByReviewId(String reviewId) {
        return pollRepository.findByReviewId(reviewId);
    }
    
    public List<Review> getTopRatedReviews(int limit) {
        return reviewRepository.findTopRatedReviews(limit);
    }
    
    public List<Review> getReviewsByCategory(String category) {
        return reviewRepository.findByCategory(category);
    }
    
    public List<Review> getRecentReviews(int limit) {
        return reviewRepository.findRecentReviews(limit);
    }
}
