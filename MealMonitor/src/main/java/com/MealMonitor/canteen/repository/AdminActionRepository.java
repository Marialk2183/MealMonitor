package com.MealMonitor.canteen.repository;

import com.MealMonitor.canteen.entity.AdminAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminActionRepository extends JpaRepository<AdminAction, Long> {
    
    List<AdminAction> findByItemId(Long itemId);
    
    List<AdminAction> findByReviewId(String reviewId);
    
    List<AdminAction> findByAdminUserId(Long adminUserId);
}
