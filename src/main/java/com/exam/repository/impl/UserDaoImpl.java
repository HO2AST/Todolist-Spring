package com.exam.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.domain.UserVO;
import com.exam.mapper.UserMapper;
import com.exam.repository.UserDao;

public class UserDaoImpl implements UserDao{
	
	@Autowired
	UserMapper userMapper;
	
	@Override
	public List<UserVO> selectUser(UserVO userVO) {
		return userMapper.selectUser(userVO);
	}
}