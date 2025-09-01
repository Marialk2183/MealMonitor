package com.MealMonitor.canteen.service;

import com.MealMonitor.canteen.entity.CanteenItem;
import com.MealMonitor.canteen.entity.AdminAction;
import com.MealMonitor.canteen.entity.AvailabilityStatus;
import com.MealMonitor.canteen.entity.ActionStatus;
import com.MealMonitor.canteen.repository.CanteenItemRepository;
import com.MealMonitor.canteen.repository.AdminActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CanteenService {
    
    @Autowired
    private CanteenItemRepository canteenItemRepository;
    
    @Autowired
    private AdminActionRepository adminActionRepository;
    
    public CanteenItem createCanteenItem(CanteenItem canteenItem) {
        canteenItem.setCreatedAt(LocalDateTime.now());
        canteenItem.setUpdatedAt(LocalDateTime.now());
        return canteenItemRepository.save(canteenItem);
    }
    
    public List<CanteenItem> getAllCanteenItems() {
        return canteenItemRepository.findAll();
    }
    
    public Optional<CanteenItem> getCanteenItemById(Long id) {
        return canteenItemRepository.findById(id);
    }
    
    public List<CanteenItem> getCanteenItemsByCategory(String category) {
        return canteenItemRepository.findByCategory(category);
    }
    
    public List<CanteenItem> getAvailableItems() {
        return canteenItemRepository.findByAvailabilityStatus(AvailabilityStatus.AVAILABLE);
    }
    
    public CanteenItem updateCanteenItem(Long id, CanteenItem itemDetails) {
        CanteenItem item = canteenItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Canteen item not found"));
        
        item.setName(itemDetails.getName());
        item.setDescription(itemDetails.getDescription());
        item.setCategory(itemDetails.getCategory());
        item.setPrice(itemDetails.getPrice());
        item.setAvailabilityStatus(itemDetails.getAvailabilityStatus());
        item.setIsSpecial(itemDetails.getIsSpecial());
        item.setSpecialNote(itemDetails.getSpecialNote());
        item.setCanteenLocation(itemDetails.getCanteenLocation());
        item.setUpdatedAt(LocalDateTime.now());
        
        return canteenItemRepository.save(item);
    }
    
    public void deleteCanteenItem(Long id) {
        canteenItemRepository.deleteById(id);
    }
    
    public AdminAction createAdminAction(AdminAction adminAction) {
        adminAction.setCreatedAt(LocalDateTime.now());
        adminAction.setUpdatedAt(LocalDateTime.now());
        return adminActionRepository.save(adminAction);
    }
    
    public List<AdminAction> getAllAdminActions() {
        return adminActionRepository.findAll();
    }
    
    public Optional<AdminAction> getAdminActionById(Long id) {
        return adminActionRepository.findById(id);
    }
    
    public List<AdminAction> getAdminActionsByItemId(Long itemId) {
        return adminActionRepository.findByItemId(itemId);
    }
    
    public AdminAction updateAdminActionStatus(Long id, ActionStatus status) {
        AdminAction action = adminActionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin action not found"));
        
        action.setStatus(status);
        action.setUpdatedAt(LocalDateTime.now());
        
        return adminActionRepository.save(action);
    }
    
    public List<CanteenItem> getSpecialItems() {
        return canteenItemRepository.findByIsSpecialTrue();
    }
    
    public List<CanteenItem> getItemsByLocation(String location) {
        return canteenItemRepository.findByCanteenLocation(location);
    }
}
