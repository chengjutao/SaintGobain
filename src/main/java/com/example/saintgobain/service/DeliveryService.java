package com.example.saintgobain.service;

import com.example.saintgobain.entity.DB_task_delivery;

/**
 * @title 交付图片
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
public interface DeliveryService {

	// 交付
	public String delivery(String phone, String token, DB_task_delivery db_task_delivery);
		
}
