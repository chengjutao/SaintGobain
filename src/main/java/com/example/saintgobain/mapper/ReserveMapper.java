package com.example.saintgobain.mapper;


import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.saintgobain.entity.DB_task_List;
import com.example.saintgobain.entity.DB_task_Reserve;


@Repository
@Mapper
public interface ReserveMapper {
	
	//查询司机是否还有执行的任务
	Map<String, Object> seltask(DB_task_List db_task_List);
	//保存执行任务
	void inserttask(DB_task_List db_task_List);
	//保存预约任务
	void inserttask_reserve(DB_task_Reserve db_task_Reserve);

	
}
