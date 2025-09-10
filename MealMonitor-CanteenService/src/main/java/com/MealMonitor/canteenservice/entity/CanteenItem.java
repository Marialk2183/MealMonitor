package com.MealMonitor.canteenservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "dish_canteen")
public class DishCanteen {
    @Id
    @Column(name = "dish_id", length = 50)
    private String dishId;

    @NotBlank
    @Size(max = 50)
    @Column(name = "menu_id")
    private String menuId;

    @NotBlank
    @Size(max = 100)
    @Column(name = "dish_name")
    private String dishName;

    @NotNull
    @Positive
    private Double price;

    @Column(name = "is_available")
    private Boolean isAvailable = true;

    @Size(max = 500)
    @Column(name = "image_url")
    private String imageURL;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    // Constructors
    public DishCanteen() {}

    public DishCanteen(String dishId, String menuId, String dishName, Double price) {
        this.dishId = dishId;
        this.menuId = menuId;
        this.dishName = dishName;
        this.price = price;
    }

    // Getters and Setters
    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
