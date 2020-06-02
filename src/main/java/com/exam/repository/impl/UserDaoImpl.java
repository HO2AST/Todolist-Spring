package com.exam.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.domain.UserVO;
import com.exam.mapper.UserMapper;
import com.exam.repository.UserDao;

@Repository("userDao")
public class UserDaoImpl implements UserDao{
	
	@Autowired
	UserMapper userMapper;
	
	@Override
	public int selectUser(UserVO userVo) {
		return userMapper.selectUser(userVo);
	}
}
