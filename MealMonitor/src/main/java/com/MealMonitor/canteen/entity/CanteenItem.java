package com.MealMonitor.canteen.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "canteen_items")
public class CanteenItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Item name is required")
    @Column(nullable = false)
    private String name;
    
    @Column(length = 500)
    private String description;
    
    @NotBlank(message = "Category is required")
    @Column(nullable = false)
    private String category;
    
    @Column(name = "price")
    private Double price;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "availability_status", nullable = false)
    private AvailabilityStatus availabilityStatus;
    
    @Column(name = "is_special")
    private Boolean isSpecial = false;
    
    @Column(name = "special_note")
    private String specialNote;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @Column(name = "canteen_location")
    private String canteenLocation;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
    
    // Constructors
    public CanteenItem() {}
    
    public CanteenItem(String name, String description, String category, AvailabilityStatus availabilityStatus) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.availabilityStatus = availabilityStatus;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
    public AvailabilityStatus getAvailabilityStatus() {
        return availabilityStatus;
    }
    
    public void setAvailabilityStatus(AvailabilityStatus availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }
    
    public Boolean getIsSpecial() {
        return isSpecial;
    }
    
    public void setIsSpecial(Boolean isSpecial) {
        this.isSpecial = isSpecial;
    }
    
    public String getSpecialNote() {
        return specialNote;
    }
    
    public void setSpecialNote(String specialNote) {
        this.specialNote = specialNote;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public String getCanteenLocation() {
        return canteenLocation;
    }
    
    public void setCanteenLocation(String canteenLocation) {
        this.canteenLocation = canteenLocation;
    }
}
