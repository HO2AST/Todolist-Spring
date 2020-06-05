package com.exam.mapper;

import java.util.List;

import com.exam.domain.TodoVO;

public interface TodoMapper {
	
	int writeTodo(TodoVO todoVO);
	
	List<TodoVO> selectTodo(String userId);
}
