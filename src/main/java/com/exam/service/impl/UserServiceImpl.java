package com.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.domain.UserVO;
import com.exam.mapper.UserMapper;
import com.exam.repository.UserDao;
import com.exam.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserMapper userMapper;
	
	@Override
	public List<UserVO> selectUser(UserVO userVO) {
		return userMapper.selectUser(userVO);
	}
}
