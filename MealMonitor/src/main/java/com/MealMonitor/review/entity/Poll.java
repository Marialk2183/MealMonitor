package com.MealMonitor.review.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Document(collection = "polls")
public class Poll {
    
    @Id
    private String id;
    
    @Field("review_id")
    @NotNull(message = "Review ID is required")
    private String reviewId;
    
    @Field("user_id")
    @NotNull(message = "User ID is required")
    private Long userId;
    
    @Field("vote_type")
    @NotNull(message = "Vote type is required")
    private VoteType voteType;
    
    @Field("created_at")
    private LocalDateTime createdAt;
    
    // Constructors
    public Poll() {}
    
    public Poll(String reviewId, Long userId, VoteType voteType) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.voteType = voteType;
        this.createdAt = LocalDateTime.now();
    }
    
    // Getters and Setters
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getReviewId() {
        return reviewId;
    }
    
    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public VoteType getVoteType() {
        return voteType;
    }
    
    public void setVoteType(VoteType voteType) {
        this.voteType = voteType;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
