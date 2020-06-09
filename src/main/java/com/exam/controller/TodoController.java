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
		System.out.println("/write" + result);
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
		System.out.println("유저아디는" + userId);
		List<Map> todoMap = todoService.selectTodo(userId);
		
		System.out.println(todoMap.size());
		System.out.println(todoMap.get(0));
		System.out.println(todoMap);
		
		JSONArray jsonArray = new JSONArray();
		for (Map<String, Object> jsonMap : todoMap) {
			jsonArray.add(jsonMap);
		}
		
		System.out.println(jsonArray);
		return jsonArray;
	}
	
	@PostMapping("/add")
	@ResponseBody
	public Map<String, Object> addTodo(@RequestBody HashMap<String, Object> map) throws Exception {
		String userId = map.get("userId").toString();
		Map<String, Object> todoMap = todoService.addTodo(userId);
		
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(todoMap);
		
		return jsonArray;
		
	}
}