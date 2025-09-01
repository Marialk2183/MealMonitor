package com.MealMonitor.dashboard.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/simple-dashboard")
@CrossOrigin(origins = "*")
public class SimpleDashboardController {
    
    @GetMapping("/stats")
    public ResponseEntity<?> getDashboardStats() {
        Map<String, Object> stats = new HashMap<>();
        
        // Mock data for demo
        stats.put("totalUsers", 150);
        stats.put("totalReviews", 45);
        stats.put("totalItems", 25);
        stats.put("unreadNotifications", 3);
        
        return ResponseEntity.ok(stats);
    }
    
    @GetMapping("/test")
    public ResponseEntity<?> testEndpoint() {
        return ResponseEntity.ok("Simple Dashboard API is working!");
    }
}


