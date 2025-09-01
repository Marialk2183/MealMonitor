package com.MealMonitor.canteen.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "admin_actions")
public class AdminAction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "item_id")
    private Long itemId;
    
    @Column(name = "review_id")
    private String reviewId;
    
    @NotBlank(message = "Action taken is required")
    @Column(name = "action_taken", nullable = false, length = 1000)
    private String actionTaken;
    
    @Column(name = "proof_image")
    private String proofImage;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ActionStatus status;
    
    @Column(name = "admin_notes")
    private String adminNotes;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @Column(name = "admin_user_id")
    @NotNull(message = "Admin user ID is required")
    private Long adminUserId;
    
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
    public AdminAction() {}
    
    public AdminAction(Long itemId, String reviewId, String actionTaken, ActionStatus status, Long adminUserId) {
        this.itemId = itemId;
        this.reviewId = reviewId;
        this.actionTaken = actionTaken;
        this.status = status;
        this.adminUserId = adminUserId;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getItemId() {
        return itemId;
    }
    
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
    
    public String getReviewId() {
        return reviewId;
    }
    
    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }
    
    public String getActionTaken() {
        return actionTaken;
    }
    
    public void setActionTaken(String actionTaken) {
        this.actionTaken = actionTaken;
    }
    
    public String getProofImage() {
        return proofImage;
    }
    
    public void setProofImage(String proofImage) {
        this.proofImage = proofImage;
    }
    
    public ActionStatus getStatus() {
        return status;
    }
    
    public void setStatus(ActionStatus status) {
        this.status = status;
    }
    
    public String getAdminNotes() {
        return adminNotes;
    }
    
    public void setAdminNotes(String adminNotes) {
        this.adminNotes = adminNotes;
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
    
    public Long getAdminUserId() {
        return adminUserId;
    }
    
    public void setAdminUserId(Long adminUserId) {
        this.adminUserId = adminUserId;
    }
}
