package com.exam.mapper;

import java.util.List;

import com.exam.domain.TodoVO;

public interface TodoMapper {
	List<TodoVO> writeTodo(TodoVO todoVO);
}
