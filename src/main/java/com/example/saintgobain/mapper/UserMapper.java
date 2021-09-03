package com.example.saintgobain.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.saintgobain.entity.DB_User;

@Repository
@Mapper
public interface UserMapper {
	//验证账号是否存在
	List<Map<String, Object>> verifyAccount(DB_User db_user);
	//验证账号密码是否正确
	DB_User verifyAccountPassword(DB_User db_user);
	 //存储修改登录token
	void updLoginToken(DB_User db_User);

}
