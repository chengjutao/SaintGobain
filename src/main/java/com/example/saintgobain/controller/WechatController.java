package com.example.saintgobain.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.saintgobain.utils.HttpUtils;
import com.example.saintgobain.service.WeChatService;


/**
 * @title 微信登录
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
@Controller
public class WechatController {

	@Autowired
	private WeChatService weChatService;
	/**
	 * @title 微信登录
	 * @author jutao.cheng
	 * @param code      code码
	 * @date 2021/08/16
	 * @version 1.0
	 * 
	 */
	@RequestMapping("wechat/login")
	@ResponseBody
	public String WeChatLogin(String phone, String code) {
		String token = null;
		// 验证参数是否为空
				if (HttpUtils.checkParameter(code)&&HttpUtils.checkParameter(phone)) {
					//登录生成token
					 token = weChatService.login(code,phone);
				}
				return token;
				
	}

}
