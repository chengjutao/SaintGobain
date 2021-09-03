package com.example.saintgobain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.saintgobain.Constants;
import com.example.saintgobain.entity.DB_task_Load;
import com.example.saintgobain.service.LoadService;
import com.example.saintgobain.service.WeChatService;
import com.example.saintgobain.utils.HttpUtils;



/**
 * @title 用户装载
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
@RequestMapping("/load")
@Controller
public class LoadController {

	@Autowired
    private LoadService loadService;
	@Autowired
	private WeChatService weChatService;
	
	/**
	 * @title 用户开始装载
	 * @author jutao.cheng
	 * @param token  微信用户token
	 * @date 2021/08/16
	 * @version 1.0
	 * 
	 */
	@RequestMapping("/start")
	@ResponseBody
	public String start(String phone,String token,DB_task_Load db_task_Load) {
		// 验证参数是否为空
		if (!HttpUtils.checkParameter(token)) {
			return HttpUtils.getParamterErrorMessage(Constants.HTTP_INVALIDATIN,null);
		}
		//验证token
		Boolean verify = weChatService.verify(token);
		if(!verify) {
			return HttpUtils.getParamterErrorMessage(Constants.HTTP_INVALIDATIN,null);
		}
		//开始装载
		String rederve = loadService.start(phone,token,db_task_Load);
		return rederve;
	}
	/**
	 * @title 用户结束装载
	 * @author jutao.cheng
	 * @param token  微信用户token
	 * @date 2021/08/16
	 * @version 1.0
	 * 
	 */
	@RequestMapping("/end")
	@ResponseBody
	public String end(String phone,String token,DB_task_Load db_task_Load) {
		// 验证参数是否为空
		if (!HttpUtils.checkParameter(token)) {
			return HttpUtils.getParamterErrorMessage(Constants.HTTP_INVALIDATIN,null);
		}
		//验证token
		Boolean verify = weChatService.verify(token);
		if(!verify) {
			return HttpUtils.getParamterErrorMessage(Constants.HTTP_INVALIDATIN,null);
		}
		//结束装载
		String rederve = loadService.end(phone,token,db_task_Load);
		return rederve;
	}
}
