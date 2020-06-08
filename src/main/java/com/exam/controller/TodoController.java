package com.exam.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.domain.TodoVO;
import com.exam.service.TodoService;

@Controller
@RequestMapping("/todo")
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
//	(value = "", method = {RequestMethod.POST,RequestMethod.GET})
	@RequestMapping
	public String todoMain() throws Exception {
		return "todolist/todolist";
	}
	
	@PostMapping("/write")
	@ResponseBody
	public String todolist(TodoVO todoVO, Model model) throws Exception {
		
		int result = todoService.writeTodo(todoVO);
		System.out.println("/write" + result);
		if (result == 1) {
			return "11";
		} else {
			return "00";
		}
	}
	
	@PostMapping("/select")
	@ResponseBody
	public List<Map> selectTodo(@RequestParam("userId") String userId) throws Exception {
		System.out.println("유저아디는" + userId);
		List<Map> todoMap = todoService.selectTodo(userId);
		
		System.out.println(todoMap.get(0));
		
		return todoMap;
	}
}