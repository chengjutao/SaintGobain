package com.example.saintgobain.mapper;



import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.saintgobain.entity.DB_task_Leave;


@Repository
@Mapper
public interface LeaveMapper {
	
	//保存离场任务
	void insertleave(DB_task_Leave db_task_Leave);
	//查询是否已离场
	Map<String, Object> selectleave(DB_task_Leave db_task_Approach);

	
}
