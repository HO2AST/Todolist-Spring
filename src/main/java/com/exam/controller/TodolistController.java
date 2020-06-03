package com.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todolist")
public class TodolistController {
	
	@GetMapping("/todolist")
	public String todolist() {
		return "todolist/todolist";
	}
}
