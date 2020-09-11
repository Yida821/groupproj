package com.example.groupproject1.dao;
import com.example.groupproject1.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, Integer> {
    UserDetail findByUsername(String user_name);
    UserDetail findById(int id);
    @Transactional
    void deleteById(int id);
}