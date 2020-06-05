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
@RequestMapping("/todolist")
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	@GetMapping("/")
	public String todoMain() throws Exception {
		return "todolist/todolist";
	}
	
	@PostMapping("/write")
	@ResponseBody
	public String todolist(TodoVO todoVO, Model model) throws Exception {
		
		int result = todoService.writeTodo(todoVO);
		System.out.println("/write" + result);
		if (result == 1) {
			return "1";
		} else {
			return "0";
		}
	}
	
	@GetMapping("/select")
	@ResponseBody
	public List<TodoVO> selectTodo(@RequestParam("userId") String userId) throws Exception {
		System.out.println(userId);
		List<TodoVO> list = todoService.selectTodo(userId);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println("아니" + list.get(i));
		}
		
		return list;
	}
}