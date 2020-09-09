package com.example.groupproject1.service.impl;
import com.example.groupproject1.dao.UserRepository;
import com.example.groupproject1.model.User;
import  com.example.groupproject1.service.UserService;
import com.example.groupproject1.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
 import java.util.List;

@Transactional //as suggested
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (s == null || "".equals(s))
        {
            throw new RuntimeException("user name cannot be empty");
        }
        User user = userService.findByUsername(s);
        if (user == null)
        {
            throw new RuntimeException("user does not exist");
        }
        //未来如果role是单独的表，和user多对多，authorities是多个对应role，现在这个list只有一个role
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userService.findRoleByUserName(s));
        authorities.add(authority);
        return new org.springframework.security.core.userdetails.User(user.getUsername(),new BCryptPasswordEncoder().encode(user.getPassword()),authorities);



    }
}


