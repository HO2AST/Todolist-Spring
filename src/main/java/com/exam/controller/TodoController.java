package com.exam.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		if (result == 1) {
			return "11";
		} else {
			return "00";
		}
	}
	
	@PostMapping("/select")
	@ResponseBody
	public List<Map> selectTodo(@RequestBody HashMap<String, Object> map) throws Exception {
		String userId = map.get("userId").toString();
		List<Map> todoMap = todoService.selectTodo(userId);
		
		JSONArray jsonArray = new JSONArray();
		for (Map<String, Object> jsonMap : todoMap) {
			jsonArray.add(jsonMap);
		}
		
		return jsonArray;
	}
	
	@PostMapping("/add")
	@ResponseBody
	public List<Map> addTodo(@RequestBody HashMap<String, Object> map) throws Exception {
		String userId = map.get("userId").toString();
		List<Map> todoMap = todoService.addTodo(userId);
		
		return todoMap;
	}
}