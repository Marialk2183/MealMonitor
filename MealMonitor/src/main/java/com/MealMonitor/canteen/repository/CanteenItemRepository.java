package com.MealMonitor.canteen.repository;

import com.MealMonitor.canteen.entity.CanteenItem;
import com.MealMonitor.canteen.entity.AvailabilityStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CanteenItemRepository extends JpaRepository<CanteenItem, Long> {
    
    List<CanteenItem> findByCategory(String category);
    
    List<CanteenItem> findByAvailabilityStatus(AvailabilityStatus availabilityStatus);
    
    List<CanteenItem> findByIsSpecialTrue();
    
    List<CanteenItem> findByCanteenLocation(String canteenLocation);
    
    List<CanteenItem> findByNameContainingIgnoreCase(String name);
}
