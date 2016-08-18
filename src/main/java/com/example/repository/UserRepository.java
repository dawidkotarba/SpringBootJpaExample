package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Dawid on 18.08.2016.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUsername(String username);
}
