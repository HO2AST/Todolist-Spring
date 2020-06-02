package com.exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.domain.UserVO;
import com.exam.repository.UserDao;
import com.exam.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;
	
	@Override
	public int selectUser(String userId, String userPasswd) {
		return userDao.selectUser(userVo);
	}
}
