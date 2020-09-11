package com.example.groupproject1.service;

import com.example.groupproject1.model.User;

import java.util.List;


public interface UserService {
    User findByUsername(String username);
    User findById(int id);
    User saveUser(User user);
    User updateUser(User user);
    List<User> findAll();
    void deleteById(int id);
}
