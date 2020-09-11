package com.example.groupproject1;

import com.example.groupproject1.dao.UserRepository;
import com.example.groupproject1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws
            UsernameNotFoundException {

        if (username == null || "".equals(username) ) {
            throw new RuntimeException("User name cannot be empty");
        }

        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("not found this username!");
        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(user.getRole())); //user.getRole is an Role emnum

        return new
                org.springframework.security.core.userdetails.User(user.getUsername(),
                new BCryptPasswordEncoder().encode(user.getPassword()), authorities); }

}
