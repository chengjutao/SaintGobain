package com.example.saintgobain.service;

import com.example.saintgobain.entity.DB_task_Leave;

/**
 * @title 离场
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
public interface LeaveService {

	//离场
	public String leave(String phone, String token, DB_task_Leave db_task_Leave);
		
}
