package com.MealMonitor.review.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

public class ReviewDto {
    
    private String id;
    
    @NotNull(message = "User ID is required")
    private Long userId;
    
    @NotBlank(message = "Food item name is required")
    @Size(max = 200, message = "Food item name must be less than 200 characters")
    private String foodItem;
    
    @NotBlank(message = "Description is required")
    @Size(max = 1000, message = "Description must be less than 1000 characters")
    private String description;
    
    private String imageUrl;
    
    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must be at most 5")
    private Integer rating;
    
    private Boolean isAnonymous = false;
    
    private Boolean isFlagged = false;
    
    private String flagReason;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
    
    private String category;
    
    private String canteenLocation;
    
    // Constructors
    public ReviewDto() {}
    
    public ReviewDto(Long userId, String foodItem, String description, Integer rating) {
        this.userId = userId;
        this.foodItem = foodItem;
        this.description = description;
        this.rating = rating;
    }
    
    // Getters and Setters
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getFoodItem() {
        return foodItem;
    }
    
    public void setFoodItem(String foodItem) {
        this.foodItem = foodItem;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getImageUrl() {
        return imageUrl;
    }
    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public Integer getRating() {
        return rating;
    }
    
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    
    public Boolean getIsAnonymous() {
        return isAnonymous;
    }
    
    public void setIsAnonymous(Boolean isAnonymous) {
        this.isAnonymous = isAnonymous;
    }
    
    public Boolean getIsFlagged() {
        return isFlagged;
    }
    
    public void setIsFlagged(Boolean isFlagged) {
        this.isFlagged = isFlagged;
    }
    
    public String getFlagReason() {
        return flagReason;
    }
    
    public void setFlagReason(String flagReason) {
        this.flagReason = flagReason;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public String getCanteenLocation() {
        return canteenLocation;
    }
    
    public void setCanteenLocation(String canteenLocation) {
        this.canteenLocation = canteenLocation;
    }
}
