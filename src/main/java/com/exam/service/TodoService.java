package com.exam.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.exam.domain.TodoVO;

public interface TodoService {
	
	int writeTodo(TodoVO todoVO);
	
	List<Map> selectTodo(String userId);
}
