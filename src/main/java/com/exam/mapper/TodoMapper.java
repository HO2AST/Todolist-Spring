package com.exam.mapper;

import java.util.List;

import com.exam.domain.TodoVO;

public interface TodoMapper {
	void writeTodo(TodoVO todoVO);
	
	List<TodoVO> selectTodo(String userId);
}
