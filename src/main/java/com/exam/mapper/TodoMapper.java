package com.exam.mapper;

import java.util.List;
import java.util.Map;

import com.exam.domain.TodoVO;

public interface TodoMapper {
	
	int writeTodo(TodoVO todoVO);	
	
	List<Map> selectTodo(String userId);
}
