package com.exam.repository;

import com.exam.domain.UserVO;

public interface UserDao {
	int selectUser(UserVO userVo);
}
