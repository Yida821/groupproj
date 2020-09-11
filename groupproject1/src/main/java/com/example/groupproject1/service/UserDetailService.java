package com.example.groupproject1.service;

import com.example.groupproject1.model.UserDetail;

import java.util.List;



public interface UserDetailService {
    UserDetail findByUsername(String username);
    UserDetail findById(int id);
    UserDetail saveUserDetail(UserDetail user);
    UserDetail updateUserDetail(UserDetail user);
    List<UserDetail> findAll();
    void deleteById(int id);
}
