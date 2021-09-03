package com.example.saintgobain.mapper;



import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.saintgobain.entity.DB_task_Approach;


@Repository
@Mapper
public interface ApproachMapper {
	
	//保存进场任务
	void insertapproach(DB_task_Approach db_task_Approach);
	//查询是否已进场
	Map<String, Object> selectapproach(DB_task_Approach db_task_Approach);

	
}
