package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exam.domain.UserVO;
import com.exam.service.UserService;

@Controller
@RequestMapping("/member/*")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/login")
	public String login(UserVO userVO) {
		
		List<UserVO> list = userService.selectUser(userVO);
		
		if (list.size() > 0) {
			System.out.println("로그인완료");
		}
		return "todolist/todolist";
	}
}
