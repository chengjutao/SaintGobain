package com.example.saintgobain.service;

import com.example.saintgobain.entity.DB_task_Reserve;

/**
 * @title 提货预约
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
public interface ReserveService {

	//提货预约
	public String rederve(String phone, String token, DB_task_Reserve db_task_Reserve);
	
}
