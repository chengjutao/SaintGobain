package com.example.saintgobain.mapper;



import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.saintgobain.entity.DB_task_Load;


@Repository
@Mapper
public interface LoadMapper {
	//查询装载信息
	Map<String, Object> selectstartload(DB_task_Load db_task_Load);
	//保存开始装载信息
	void insertstartload(DB_task_Load db_task_Load);
	//修改结束装载信息
	void updateendload(DB_task_Load db_task_Load);

	
}
