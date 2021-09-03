package com.example.saintgobain.mapper;



import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.saintgobain.entity.DB_task_Signin;


@Repository
@Mapper
public interface SignInMapper {
	
	//保存签到任务
	void insertsignin(DB_task_Signin db_task_Signin);
	//查询是否已经签到
	Map<String, Object> selectsignin(DB_task_Signin db_task_Signin);

	
}
