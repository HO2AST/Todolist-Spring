package com.exam.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.domain.TodoVO;
import com.exam.service.TodoService;

@Controller
@RequestMapping("/todolist/")
public class TodolistController {
	
	@Autowired
	TodoService todoService;
	
	@GetMapping("/")
	public String todoMain() {
		return "todolist/todolist";
	}
	
	@PostMapping("/write")
	@ResponseBody
	public String todolist(TodoVO todoVO, Model model) {
		
		int result = todoService.writeTodo(todoVO);
		
		if (result == 1) {
			return "1";
		} else {
			return "0";
		}
	}
	
	@GetMapping("/select")
	@ResponseBody
	public List<TodoVO> selectTodo(@RequestParam("userId") String userId) {
		List<TodoVO> list = todoService.selectTodo(userId);
		return list;
	}
}