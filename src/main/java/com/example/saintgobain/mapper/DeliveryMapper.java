package com.example.saintgobain.mapper;



import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.saintgobain.entity.DB_task_delivery;


@Repository
@Mapper
public interface DeliveryMapper {
	
	//保存交付图片任务
	void insertdelivery(DB_task_delivery db_task_delivery);
	//查询是否已交付
	Map<String, Object> selectdelivery(DB_task_delivery db_task_delivery);

	
}
