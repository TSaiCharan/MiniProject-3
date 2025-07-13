package com.company.coursereviewapi.controller;

import com.company.coursereviewapi.model.User;
import com.company.coursereviewapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("users/{id}")
    public User getUser(@PathVariable Long id){
        return userService.findById(id);
    }



}
