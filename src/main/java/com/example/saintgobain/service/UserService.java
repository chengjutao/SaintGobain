package com.example.saintgobain.service;

import com.example.saintgobain.entity.DB_User;

/**
 * @title 用户登录接口
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
public interface UserService {

	//生成token接口
	public String birthtoken(DB_User db_user);
	
}
