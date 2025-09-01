package com.MealMonitor.user.repository;

import com.MealMonitor.user.entity.User;
import com.MealMonitor.user.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByEmail(String email);
    
    List<User> findByRole(UserRole role);
    
    List<User> findByIsActive(Boolean isActive);
    
    Optional<User> findByEmailAndIsActive(String email, Boolean isActive);
}
