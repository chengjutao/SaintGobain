package com.example.saintgobain.service;

 import com.example.saintgobain.entity.DB_task_Load;

/**
 * @title 装载
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
public interface LoadService {

	//开始装载
	public String start(String phone, String token, DB_task_Load db_task_Load);
	//结束装载
	public String end(String phone, String token, DB_task_Load db_task_Load);
	
}
