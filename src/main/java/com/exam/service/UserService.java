package com.exam.service;

import java.util.List;

import com.exam.domain.UserVO;

public interface UserService {
	
	List<UserVO> selectUser(UserVO userVO);
}
