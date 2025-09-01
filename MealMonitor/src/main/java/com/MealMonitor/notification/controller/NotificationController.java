package com.MealMonitor.notification.controller;

import com.MealMonitor.notification.entity.Notification;
import com.MealMonitor.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin(origins = "*")
public class NotificationController {
    
    @Autowired
    private NotificationService notificationService;
    
    @PostMapping
    public ResponseEntity<?> createNotification(@RequestBody Notification notification) {
        try {
            Notification createdNotification = notificationService.createNotification(notification);
            return ResponseEntity.ok(createdNotification);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating notification: " + e.getMessage());
        }
    }
    
    @GetMapping
    public ResponseEntity<?> getAllNotifications() {
        try {
            List<Notification> notifications = notificationService.getAllNotifications();
            return ResponseEntity.ok(notifications);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error retrieving notifications: " + e.getMessage());
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getNotificationById(@PathVariable Long id) {
        try {
            Notification notification = notificationService.getNotificationById(id).orElse(null);
            if (notification != null) {
                return ResponseEntity.ok(notification);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error retrieving notification: " + e.getMessage());
        }
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getNotificationsByUserId(@PathVariable Long userId) {
        try {
            List<Notification> notifications = notificationService.getNotificationsByUserId(userId);
            return ResponseEntity.ok(notifications);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error retrieving user notifications: " + e.getMessage());
        }
    }
    
    @GetMapping("/user/{userId}/unread")
    public ResponseEntity<?> getUnreadNotificationsByUserId(@PathVariable Long userId) {
        try {
            List<Notification> notifications = notificationService.getUnreadNotificationsByUserId(userId);
            return ResponseEntity.ok(notifications);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error retrieving unread notifications: " + e.getMessage());
        }
    }
    
    @PutMapping("/{id}/read")
    public ResponseEntity<?> markAsRead(@PathVariable Long id) {
        try {
            Notification notification = notificationService.markAsRead(id);
            return ResponseEntity.ok(notification);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error marking notification as read: " + e.getMessage());
        }
    }
    
    @PutMapping("/{id}/archive")
    public ResponseEntity<?> markAsArchived(@PathVariable Long id) {
        try {
            Notification notification = notificationService.markAsArchived(id);
            return ResponseEntity.ok(notification);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error archiving notification: " + e.getMessage());
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNotification(@PathVariable Long id) {
        try {
            notificationService.deleteNotification(id);
            return ResponseEntity.ok("Notification deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error deleting notification: " + e.getMessage());
        }
    }

    @GetMapping("/user")
    public ResponseEntity<?> getCurrentUserNotifications() {
        try {
            // This would need to be implemented with proper authentication context
            // For now, returning all notifications as placeholder
            List<Notification> notifications = notificationService.getAllNotifications();
            return ResponseEntity.ok(notifications);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error retrieving user notifications: " + e.getMessage());
        }
    }
}
