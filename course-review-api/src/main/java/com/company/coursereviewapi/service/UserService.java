package com.company.coursereviewapi.service;

import com.company.coursereviewapi.model.User;
import com.company.coursereviewapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }
}
