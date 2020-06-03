package com.exam.service;

import java.util.List;

import com.exam.domain.TodoVO;

public interface TodoService {
	
	List<TodoVO> writeTodo(TodoVO todoVO);
}
