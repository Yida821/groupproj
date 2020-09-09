package com.example.groupproject1;

import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//		(exclude = {SecurityAutoConfiguration.class })
public class Groupproject1Application {

	public static void main(String[] args) {
		SpringApplication.run(Groupproject1Application.class, args);

	}
//	@RequestMapping("/data")
//	public String test(){
//		return "This is data.";
//		}
}
