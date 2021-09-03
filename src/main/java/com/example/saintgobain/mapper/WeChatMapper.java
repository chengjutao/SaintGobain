package com.example.saintgobain.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.saintgobain.entity.DB_WeChat;

@Repository
@Mapper
public interface WeChatMapper {
	 //存储修改登录token
	public void insertdriver(DB_WeChat DB_WeChat);
	//存储修改登录token
	public void updatedriver(DB_WeChat DB_WeChat);
	//验证查询登录电话是否存在
	public List<Map<String, Object>> verifyphone(String phone) ;
	//查询司机是否存在
	public Map<String, Object> seldriver(DB_WeChat db_WeChat);
	//验证token
	public Integer WeChatverify(String token);
}
