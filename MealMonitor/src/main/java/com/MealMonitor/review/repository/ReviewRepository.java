package com.MealMonitor.review.repository;

import com.MealMonitor.review.entity.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {
    
    List<Review> findByUserId(Long userId);
    
    List<Review> findByIsFlaggedTrue();
    
    List<Review> findByCategory(String category);
    
    @Query(value = "{}", sort = "{'rating': -1}")
    List<Review> findTopRatedReviews(int limit);
    
    List<Review> findByFoodItemContainingIgnoreCase(String foodItem);
    
    List<Review> findByCanteenLocation(String canteenLocation);
    
    @Query(value = "{}", sort = "{'createdAt': -1}")
    List<Review> findRecentReviews(int limit);
}
