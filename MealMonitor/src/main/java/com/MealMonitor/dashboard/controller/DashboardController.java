package com.MealMonitor.dashboard.controller;

import com.MealMonitor.user.service.UserService;
import com.MealMonitor.review.service.ReviewService;
import com.MealMonitor.canteen.service.CanteenService;
import com.MealMonitor.notification.service.NotificationService;
import com.MealMonitor.review.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "*")
public class DashboardController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private ReviewService reviewService;
    
    @Autowired
    private CanteenService canteenService;
    
    @Autowired
    private NotificationService notificationService;
    
    @GetMapping("/stats")
    public ResponseEntity<?> getDashboardStats() {
        try {
            Map<String, Object> stats = new HashMap<>();
            
            // Mock data for demo
            stats.put("totalUsers", 150);
            stats.put("totalReviews", 45);
            stats.put("totalItems", 25);
            stats.put("unreadNotifications", 3);
            
            return ResponseEntity.ok(stats);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error retrieving dashboard stats: " + e.getMessage());
        }
    }
    
    @GetMapping("/test")
    public ResponseEntity<?> testEndpoint() {
        return ResponseEntity.ok("Dashboard API is working!");
    }
}
