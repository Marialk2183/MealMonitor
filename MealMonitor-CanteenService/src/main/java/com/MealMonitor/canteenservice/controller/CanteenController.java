package com.MealMonitor.canteenservice.controller;

import com.MealMonitor.canteenservice.entity.CanteenItem;
import com.MealMonitor.canteenservice.service.CanteenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/canteen")
@CrossOrigin(origins = "*")
public class CanteenController {

    @Autowired
    private CanteenService canteenService;

    @GetMapping("/items")
    public ResponseEntity<List<CanteenItem>> getAllItems() {
        List<CanteenItem> items = canteenService.getAllItems();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/items/category/{category}")
    public ResponseEntity<List<CanteenItem>> getItemsByCategory(@PathVariable String category) {
        List<CanteenItem> items = canteenService.getItemsByCategory(category);
        return ResponseEntity.ok(items);
    }

    @GetMapping("/items/available")
    public ResponseEntity<List<CanteenItem>> getAvailableItems() {
        List<CanteenItem> items = canteenService.getAvailableItems();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/items/search")
    public ResponseEntity<List<CanteenItem>> searchItems(@RequestParam String name) {
        List<CanteenItem> items = canteenService.searchItems(name);
        return ResponseEntity.ok(items);
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<?> getItemById(@PathVariable Long id) {
        try {
            CanteenItem item = canteenService.getItemById(id);
            return ResponseEntity.ok(item);
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/items")
    public ResponseEntity<?> createItem(@Valid @RequestBody CanteenItem item) {
        try {
            CanteenItem createdItem = canteenService.createItem(item);
            return ResponseEntity.ok(createdItem);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Failed to create item: " + e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<?> updateItem(@PathVariable Long id, @Valid @RequestBody CanteenItem itemDetails) {
        try {
            CanteenItem updatedItem = canteenService.updateItem(id, itemDetails);
            return ResponseEntity.ok(updatedItem);
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Long id) {
        try {
            canteenService.deleteItem(id);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Item deleted successfully");
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}
