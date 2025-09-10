package com.MealMonitor.reviewservice.repository;

import com.MealMonitor.reviewservice.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByItemName(String itemName);
    List<Review> findByUserId(Long userId);
    List<Review> findByRating(Integer rating);
    List<Review> findByItemNameContainingIgnoreCase(String itemName);
}
