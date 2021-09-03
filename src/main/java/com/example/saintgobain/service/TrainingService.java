package com.example.saintgobain.service;

import com.example.saintgobain.entity.DB_task_Training;

/**
 * @title 进场须知
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
public interface TrainingService {

	//进场须知
	public String comeinnotice (String phone, String token, DB_task_Training db_task_Training);
	//疫情阅读
	public String epidemic(String phone, String token, DB_task_Training db_task_Training);
	//承诺书
	public String promise(String phone, String token, DB_task_Training db_task_Training);
	
}
