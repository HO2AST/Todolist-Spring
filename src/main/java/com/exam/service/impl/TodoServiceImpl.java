package com.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.domain.TodoVO;
import com.exam.mapper.TodoMapper;
import com.exam.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService{
	
	@Autowired
	TodoMapper todoMapper;
	
	@Override
	public List<TodoVO> writeTodo(TodoVO todoVO) {
		return todoMapper.writeTodo(todoVO);
	}
}
