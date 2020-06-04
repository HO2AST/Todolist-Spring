package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.domain.TodoVO;
import com.exam.service.TodoService;

@Controller
@RequestMapping("/todolist")
public class TodolistController {
	
	@Autowired
	TodoService todoService;
	
	@GetMapping
	public String todoMain() {
		return "todolist/todolist";
	}
	
	@PostMapping("/write")
	@ResponseBody
	public String todolist(TodoVO todoVO, Model model) {
		
		todoService.writeTodo(todoVO);
		String userId = todoVO.getUserId();
		List<TodoVO> list = todoService.selectTodo(userId);
		
		if (list.size() > 0) {
			model.addAttribute("todoList", list);
			return "1";
		} else {
			return "0";
		}
	}
}