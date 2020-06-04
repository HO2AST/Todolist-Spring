package com.exam.service;

import java.util.List;

import com.exam.domain.TodoVO;

public interface TodoService {
	
	void writeTodo(TodoVO todoVO);
	
	List<TodoVO> selectTodo(String userId);
}
