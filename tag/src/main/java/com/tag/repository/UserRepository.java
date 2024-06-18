package com.tag.repository;

import com.tag.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    String findByUsername(String username);
    String findByPassword(String password);
}
