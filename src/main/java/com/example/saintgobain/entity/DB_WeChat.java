package com.example.saintgobain.entity;

/**
 * @title 微信用户信息
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
public class DB_WeChat {

	 /**
     * 手机号
     */
    private String phone;
    /**
     * token
     */
    private String token;
    /**
     * 登录时间
     */
    private String datetime;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
    
    
}
