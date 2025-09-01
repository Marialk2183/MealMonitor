package com.MealMonitor.notification.service;

import com.MealMonitor.notification.entity.Notification;
import com.MealMonitor.notification.entity.NotificationType;
import com.MealMonitor.notification.entity.NotificationStatus;
import com.MealMonitor.notification.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {
    
    @Autowired
    private NotificationRepository notificationRepository;
    
    public Notification createNotification(Notification notification) {
        notification.setCreatedAt(LocalDateTime.now());
        notification.setStatus(NotificationStatus.UNREAD);
        return notificationRepository.save(notification);
    }
    
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }
    
    public Optional<Notification> getNotificationById(Long id) {
        return notificationRepository.findById(id);
    }
    
    public List<Notification> getNotificationsByUserId(Long userId) {
        return notificationRepository.findByUserId(userId);
    }
    
    public List<Notification> getUnreadNotificationsByUserId(Long userId) {
        return notificationRepository.findByUserIdAndStatus(userId, NotificationStatus.UNREAD);
    }
    
    public Notification markAsRead(Long notificationId) {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
        
        notification.setStatus(NotificationStatus.READ);
        notification.setReadAt(LocalDateTime.now());
        
        return notificationRepository.save(notification);
    }
    
    public Notification markAsArchived(Long notificationId) {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
        
        notification.setStatus(NotificationStatus.ARCHIVED);
        
        return notificationRepository.save(notification);
    }
    
    public List<Notification> getNotificationsByType(NotificationType type) {
        return notificationRepository.findByType(type);
    }
    
    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }
    
    public List<Notification> getNotificationsByRelatedId(String relatedId) {
        return notificationRepository.findByRelatedId(relatedId);
    }
    
    public List<Notification> getNotificationsByRelatedType(String relatedType) {
        return notificationRepository.findByRelatedType(relatedType);
    }
}
