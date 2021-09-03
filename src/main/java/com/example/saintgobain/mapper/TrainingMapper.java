package com.example.saintgobain.mapper;


import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.saintgobain.entity.DB_task_Training;


@Repository
@Mapper
public interface TrainingMapper {
	
	//查询司机是否已经保存进场须知的任务
	Map<String, Object> selectcomein(DB_task_Training db_task_Training);
	//保存进场须知任务
	void inserttraining(DB_task_Training db_task_Training);
	//修改进场须知任务疫情
	void updateepidemic(DB_task_Training db_task_Training);
	//修改进场须知任务承诺书
	void updatepromise(DB_task_Training db_task_Training);

	
}
