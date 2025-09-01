package com.MealMonitor.canteen.controller;

import com.MealMonitor.canteen.entity.CanteenItem;
import com.MealMonitor.canteen.entity.AdminAction;
import com.MealMonitor.canteen.entity.ActionStatus;
import com.MealMonitor.canteen.service.CanteenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/canteen")
@CrossOrigin(origins = "*")
public class CanteenController {
    
    @Autowired
    private CanteenService canteenService;
    
    @PostMapping("/items")
    public ResponseEntity<?> createCanteenItem(@RequestBody CanteenItem canteenItem) {
        try {
            CanteenItem item = canteenService.createCanteenItem(canteenItem);
            return ResponseEntity.ok(item);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating canteen item: " + e.getMessage());
        }
    }
    
    @GetMapping("/items")
    public ResponseEntity<?> getAllCanteenItems() {
        try {
            List<CanteenItem> items = canteenService.getAllCanteenItems();
            return ResponseEntity.ok(items);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error retrieving canteen items: " + e.getMessage());
        }
    }
    
    @GetMapping("/items/{id}")
    public ResponseEntity<?> getCanteenItemById(@PathVariable Long id) {
        try {
            CanteenItem item = canteenService.getCanteenItemById(id).orElse(null);
            if (item != null) {
                return ResponseEntity.ok(item);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error retrieving canteen item: " + e.getMessage());
        }
    }
    
    @GetMapping("/items/category/{category}")
    public ResponseEntity<?> getCanteenItemsByCategory(@PathVariable String category) {
        try {
            List<CanteenItem> items = canteenService.getCanteenItemsByCategory(category);
            return ResponseEntity.ok(items);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error retrieving items by category: " + e.getMessage());
        }
    }
    
    @GetMapping("/items/available")
    public ResponseEntity<?> getAvailableItems() {
        try {
            List<CanteenItem> items = canteenService.getAvailableItems();
            return ResponseEntity.ok(items);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error retrieving available items: " + e.getMessage());
        }
    }
    
    @PutMapping("/items/{id}")
    public ResponseEntity<?> updateCanteenItem(@PathVariable Long id, @RequestBody CanteenItem itemDetails) {
        try {
            CanteenItem item = canteenService.updateCanteenItem(id, itemDetails);
            return ResponseEntity.ok(item);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error updating canteen item: " + e.getMessage());
        }
    }
    
    @DeleteMapping("/items/{id}")
    public ResponseEntity<?> deleteCanteenItem(@PathVariable Long id) {
        try {
            canteenService.deleteCanteenItem(id);
            return ResponseEntity.ok("Canteen item deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error deleting canteen item: " + e.getMessage());
        }
    }
    
    @PostMapping("/actions")
    public ResponseEntity<?> createAdminAction(@RequestBody AdminAction adminAction) {
        try {
            AdminAction action = canteenService.createAdminAction(adminAction);
            return ResponseEntity.ok(action);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating admin action: " + e.getMessage());
        }
    }
    
    @GetMapping("/actions")
    public ResponseEntity<?> getAllAdminActions() {
        try {
            List<AdminAction> actions = canteenService.getAllAdminActions();
            return ResponseEntity.ok(actions);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error retrieving admin actions: " + e.getMessage());
        }
    }
    
    @GetMapping("/actions/{id}")
    public ResponseEntity<?> getAdminActionById(@PathVariable Long id) {
        try {
            AdminAction action = canteenService.getAdminActionById(id).orElse(null);
            if (action != null) {
                return ResponseEntity.ok(action);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error retrieving admin action: " + e.getMessage());
        }
    }
    
    @GetMapping("/actions/item/{itemId}")
    public ResponseEntity<?> getAdminActionsByItemId(@PathVariable Long itemId) {
        try {
            List<AdminAction> actions = canteenService.getAdminActionsByItemId(itemId);
            return ResponseEntity.ok(actions);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error retrieving admin actions by item: " + e.getMessage());
        }
    }
    
    @PutMapping("/actions/{id}/status")
    public ResponseEntity<?> updateAdminActionStatus(@PathVariable Long id, @RequestBody Map<String, String> request) {
        try {
            ActionStatus status = ActionStatus.valueOf(request.get("status").toUpperCase());
            AdminAction action = canteenService.updateAdminActionStatus(id, status);
            return ResponseEntity.ok(action);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error updating admin action status: " + e.getMessage());
        }
    }
    
    @GetMapping("/items/special")
    public ResponseEntity<?> getSpecialItems() {
        try {
            List<CanteenItem> items = canteenService.getSpecialItems();
            return ResponseEntity.ok(items);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error retrieving special items: " + e.getMessage());
        }
    }
    
    @GetMapping("/items/location/{location}")
    public ResponseEntity<?> getItemsByLocation(@PathVariable String location) {
        try {
            List<CanteenItem> items = canteenService.getItemsByLocation(location);
            return ResponseEntity.ok(items);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error retrieving items by location: " + e.getMessage());
        }
    }
}
