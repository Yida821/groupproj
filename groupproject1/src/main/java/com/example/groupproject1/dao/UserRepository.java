package com.example.groupproject1.dao;
import com.example.groupproject1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String user_name);
    User findById(int id);
    @Transactional
    void deleteById(int id);
    @Transactional
    void deleteByUsername(String userName);

}