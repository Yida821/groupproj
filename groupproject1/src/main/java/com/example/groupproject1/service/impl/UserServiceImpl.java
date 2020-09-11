package com.example.groupproject1.service.impl;

import com.example.groupproject1.dao.UserRepository;
import com.example.groupproject1.model.User;
import com.example.groupproject1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User findByUsername(String user_name){
        return userRepository.findByUsername(user_name);
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteById(int id){
        userRepository.deleteById(id);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
