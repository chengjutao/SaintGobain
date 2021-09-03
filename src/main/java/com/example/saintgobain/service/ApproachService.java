package com.example.saintgobain.service;

import com.example.saintgobain.entity.DB_task_Approach;

/**
 * @title 进场
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
public interface ApproachService {

	//进场
	public String approach(String phone, String token, DB_task_Approach db_task_Approach);
	
}
