package com.exam.domain;


import java.util.Date;

import lombok.Data;

@Data
public class TodoVO {
	String userId;
	String todo;
	Date regDate;
}
