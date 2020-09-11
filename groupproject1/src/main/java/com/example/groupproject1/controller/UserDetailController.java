package com.example.groupproject1.controller;

import com.example.groupproject1.model.UserDetail;
import com.example.groupproject1.dao.UserDetailRepository;
import com.example.groupproject1.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserDetailController {


    @Autowired
    private UserDetailService userDetailService;

    @GetMapping("/user_detail")
    public List<UserDetail> getAllUserDetails() {
        return userDetailService.findAll();
    }

    @PostMapping("/user_detail")
    public UserDetail createUserDetail(UserDetail userDetail) {
        return userDetailService.saveUserDetail(userDetail);
    }

    @GetMapping("/user_detail/{id}")
    public UserDetail getUserDetailById(@PathVariable(value = "id") int userId) {
        return userDetailService.findById(userId);
        //.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
    }

    @GetMapping(value = "/user_detail/findByUserName")
    public UserDetail findByUserName(String username) {
        return userDetailService.findByUsername(username);
    }

    @PutMapping("/user_detail/updatePasswordById")
    public UserDetail updatePasswordById(int id, String password) {
        UserDetail user = userDetailService.findById(id);
        user.setPassword(password);
        return userDetailService.updateUserDetail(user);
    }

    @PutMapping("/user_detail/{id}")
    public UserDetail updateUserDetail(@PathVariable(value = "id") int userId,
                                       UserDetail userDetails) {

        UserDetail user = userDetailService.findById(userId);
        //.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setEmail(userDetails.getEmail());
        user.setPhone(userDetails.getPhone());
        user.setQuestion(userDetails.getQuestion());
        user.setAnswer(userDetails.getAnswer());
        user.setRole(userDetails.getRole());

        UserDetail updatedUser = userDetailService.saveUserDetail(user);
        return updatedUser;
    }

    @Transactional
    @DeleteMapping("/user_detail/{id}")
    public ResponseEntity<?> deleteUserDetail(@PathVariable(value = "id") int userId) {
        //UserDetail user = userDetailService.findByUserId(userId)
        //.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        userDetailService.deleteById(userId);

        return ResponseEntity.ok().build();
    }
}
