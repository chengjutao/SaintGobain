package com.example.saintgobain.service;


/**
 * @title 微信登录接口
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
public interface WeChatService {

	//生成token接口
	public String login(String code, String phone);
	//验证token接口
	public Boolean verify(String token) ;
	
	
}
