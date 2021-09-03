package com.example.saintgobain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.saintgobain.Constants;
import com.example.saintgobain.entity.DB_User;
import com.example.saintgobain.service.UserService;
import com.example.saintgobain.utils.HttpUtils;

/**
 * @title 用户登录
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
@Controller
public class UserController {

	@Autowired
    private UserService userService;
	
	/**
	 * @title 用户登录
	 * @author jutao.cheng
	 * @param username 登录账号
	 * @param password 登录密码
	 * @return 返回信息{"token":"urvkowes0PPv3MLfsB3RblMOOQN1bHEGSdjcFe5sK4SBbDUoxDuhoawcXJGpy8iz","account":"13604992376"}
	 * @date 2021/08/16
	 * @version 1.0
	 * 
	 */
	@RequestMapping("/login")
	@ResponseBody
	public String Login(String account, String password) {
		// 验证参数是否为空
		if (!HttpUtils.checkParameter(account)) {
			return HttpUtils.getParamterErrorMessage(Constants.HTTP_ACCOUNT,null);
		}
		if (!HttpUtils.checkParameter(password)) {
			return HttpUtils.getParamterErrorMessage(Constants.HTTP_PASSWORD,null);
		}
		//生成登录token信息
		DB_User db_user = new DB_User();
		db_user.setPassword(password);
		db_user.setAccount(account);
		return userService.birthtoken(db_user);
	}
}
