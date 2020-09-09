package com.example.groupproject1.dto;

import lombok.Data;

import java.io.Serializable;
//这个文件暂时也没用上
@Data
//lombok 注解，NoArgsConstructor 无参数构造函数
public class UserDto implements Serializable {
    private String userName;
    private String password;
    private String email;
    private int phone;
    private String question;
    private String answer;
    private String role;
    //user.getUsername() , user.getPassword(), user.getEmail(),user.getPhone(),user.getQuestion(),
    //                user.getAnswer(), user.getRole()

    @Override
    public String toString(){
        return "UserDto{" +
                "name='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}