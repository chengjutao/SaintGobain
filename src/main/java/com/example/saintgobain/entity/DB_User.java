package com.example.saintgobain.entity;

/**
 * @title 用户实体类
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
public class DB_User {

	 /** id */
    private Integer id;
    /** 账号 */
    private String account;
    /** 密码 */
    private String password; 
    /** token */
    private String token;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
    
    
    
}
