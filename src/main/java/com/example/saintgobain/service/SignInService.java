package com.example.saintgobain.service;

import com.example.saintgobain.entity.DB_task_Signin;

/**
 * @title 签到
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
public interface SignInService {

	//签到
	public String signin(String phone, String token, DB_task_Signin db_task_Signin);
	
}
