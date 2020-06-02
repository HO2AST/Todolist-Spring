package com.exam.mapper;

import java.util.List;

import com.exam.domain.UserVO;

public interface UserMapper {
	List<UserVO> selectUser(UserVO userVO);
}
