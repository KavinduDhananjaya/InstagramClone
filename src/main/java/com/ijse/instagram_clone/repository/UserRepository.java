package com.ijse.instagram_clone.repository;
import com.ijse.instagram_clone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByEmail(String Email);
}
