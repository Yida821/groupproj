package com.example.groupproject1.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {
    @GetMapping("/admin")
    public String admin(){
        return "admin here";
    }

    @GetMapping("/data")
    public String data(){
        return "Awwwwwww you can see the data you are ADMIN!";
    }
}
