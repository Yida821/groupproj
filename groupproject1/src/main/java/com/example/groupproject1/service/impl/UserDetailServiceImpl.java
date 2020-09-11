package com.example.groupproject1.service.impl;

import com.example.groupproject1.dao.UserDetailRepository;
import com.example.groupproject1.model.UserDetail;
import com.example.groupproject1.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailService {
    @Autowired
    private UserDetailRepository userDetailRepository;
    @Override
    public UserDetail findByUsername(String user_name){
        return userDetailRepository.findByUsername(user_name);
    }

    @Override
    public UserDetail findById(int id) {
        return userDetailRepository.findById(id);

    }

    @Override
    public void deleteById(int id){
        userDetailRepository.deleteById(id);
    }

    @Override
    public UserDetail saveUserDetail(UserDetail user) {
        return userDetailRepository.save(user);

    }




    @Override
    public UserDetail updateUserDetail(UserDetail user) {
        return userDetailRepository.save(user);
    }
    @Override
    public List<UserDetail> findAll() {
        return userDetailRepository.findAll();
    }
}
