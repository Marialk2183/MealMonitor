package com.MealMonitor.review.controller;

import com.MealMonitor.review.dto.ReviewDto;
import com.MealMonitor.review.entity.Review;
import com.MealMonitor.review.entity.Poll;
import com.MealMonitor.review.entity.VoteType;
import com.MealMonitor.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {
    
    @Autowired
    private ReviewService reviewService;
    
    @PostMapping
    public ResponseEntity<?> createReview(@RequestBody ReviewDto reviewDto) {
        try {
            Review review = reviewService.createReview(reviewDto);
            return ResponseEntity.ok(review);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating review: " + e.getMessage());
        }
    }
    
    @GetMapping
    public ResponseEntity<?> getAllReviews() {
        try {
            List<Review> reviews = reviewService.getAllReviews();
            return ResponseEntity.ok(reviews);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error retrieving reviews: " + e.getMessage());
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getReviewById(@PathVariable String id) {
        try {
            Review review = reviewService.getReviewById(id).orElse(null);
            if (review != null) {
                return ResponseEntity.ok(review);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error retrieving review: " + e.getMessage());
        }
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getReviewsByUserId(@PathVariable Long userId) {
        try {
            List<Review> reviews = reviewService.getReviewsByUserId(userId);
            return ResponseEntity.ok(reviews);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error retrieving user reviews: " + e.getMessage());
        }
    }
    
    @GetMapping("/flagged")
    public ResponseEntity<?> getFlaggedReviews() {
        try {
            List<Review> reviews = reviewService.getFlaggedReviews();
            return ResponseEntity.ok(reviews);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error retrieving flagged reviews: " + e.getMessage());
        }
    }
    
    @PostMapping("/{id}/flag")
    public ResponseEntity<?> flagReview(@PathVariable String id, @RequestBody Map<String, String> request) {
        try {
            String flagReason = request.get("flagReason");
            Review review = reviewService.flagReview(id, flagReason);
            return ResponseEntity.ok(review);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error flagging review: " + e.getMessage());
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateReview(@PathVariable String id, @RequestBody ReviewDto reviewDto) {
        try {
            Review review = reviewService.updateReview(id, reviewDto);
            return ResponseEntity.ok(review);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error updating review: " + e.getMessage());
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable String id) {
        try {
            reviewService.deleteReview(id);
            return ResponseEntity.ok("Review deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error deleting review: " + e.getMessage());
        }
    }
    
    @PostMapping("/{reviewId}/poll")
    public ResponseEntity<?> createPoll(@PathVariable String reviewId, @RequestBody Map<String, Object> request) {
        try {
            Long userId = Long.valueOf(request.get("userId").toString());
            VoteType voteType = VoteType.valueOf(request.get("voteType").toString());
            Poll poll = reviewService.createPoll(reviewId, userId, voteType);
            return ResponseEntity.ok(poll);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating poll: " + e.getMessage());
        }
    }
    
    @GetMapping("/{reviewId}/polls")
    public ResponseEntity<?> getPollsByReviewId(@PathVariable String reviewId) {
        try {
            List<Poll> polls = reviewService.getPollsByReviewId(reviewId);
            return ResponseEntity.ok(polls);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error retrieving polls: " + e.getMessage());
        }
    }
    
    @GetMapping("/top-rated")
    public ResponseEntity<?> getTopRatedReviews(@RequestParam(defaultValue = "10") int limit) {
        try {
            List<Review> reviews = reviewService.getTopRatedReviews(limit);
            return ResponseEntity.ok(reviews);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error retrieving top rated reviews: " + e.getMessage());
        }
    }
    
    @GetMapping("/category/{category}")
    public ResponseEntity<?> getReviewsByCategory(@PathVariable String category) {
        try {
            List<Review> reviews = reviewService.getReviewsByCategory(category);
            return ResponseEntity.ok(reviews);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error retrieving reviews by category: " + e.getMessage());
        }
    }
    
    @GetMapping("/recent")
    public ResponseEntity<?> getRecentReviews(@RequestParam(defaultValue = "10") int limit) {
        try {
            List<Review> reviews = reviewService.getRecentReviews(limit);
            return ResponseEntity.ok(reviews);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error retrieving recent reviews: " + e.getMessage());
        }
    }
    
    @GetMapping("/user")
    public ResponseEntity<?> getCurrentUserReviews() {
        try {
            // This would need to be implemented with proper authentication context
            // For now, returning all reviews as placeholder
            List<Review> reviews = reviewService.getAllReviews();
            return ResponseEntity.ok(reviews);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error retrieving user reviews: " + e.getMessage());
        }
    }
}
