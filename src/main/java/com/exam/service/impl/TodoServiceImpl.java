package com.exam.service.impl;

import java.util.List;
import java.util.Map;

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
	public int writeTodo(TodoVO todoVO) {
		return todoMapper.writeTodo(todoVO);
	}
	
	@Override
	public List<Map> selectTodo(String userId) {
		return todoMapper.selectTodo(userId);
	}
}
