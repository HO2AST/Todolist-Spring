package com.exam.repository;

import java.util.List;

import com.exam.domain.UserVO;

public interface UserDao {
	List<UserVO> selectUser(UserVO userVO);
}
