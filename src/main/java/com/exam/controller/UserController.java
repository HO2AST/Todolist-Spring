package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exam.service.UserService;

@Controller
@RequestMapping("/member/*")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/login")
	public String login(String userId, String userPasswd) {
		int flag = userService.selectUser();
		return "todolist/todolist";
	}
}
