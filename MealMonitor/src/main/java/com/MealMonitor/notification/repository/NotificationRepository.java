package com.MealMonitor.notification.repository;

import com.MealMonitor.notification.entity.Notification;
import com.MealMonitor.notification.entity.NotificationType;
import com.MealMonitor.notification.entity.NotificationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    
    List<Notification> findByUserId(Long userId);
    
    List<Notification> findByUserIdAndStatus(Long userId, NotificationStatus status);
    
    List<Notification> findByType(NotificationType type);
    
    List<Notification> findByRelatedId(String relatedId);
    
    List<Notification> findByRelatedType(String relatedType);
    
    List<Notification> findByStatus(NotificationStatus status);
}
