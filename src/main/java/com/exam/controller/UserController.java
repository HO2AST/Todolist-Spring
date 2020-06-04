package com.exam.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.domain.UserVO;
import com.exam.service.UserService;

@Controller
@RequestMapping("/member")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/login")
	@ResponseBody
	public String login(HttpSession session, UserVO userVO) {

		List<UserVO> list = userService.selectUser(userVO);
	
		if (list.size() > 0) { 
			session.setAttribute("id", userVO.getUserId());
			return "1";
		} else { 
			return "0"; 
		}

	}
}
