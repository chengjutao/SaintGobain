package com.example.saintgobain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.saintgobain.Constants;
import com.example.saintgobain.entity.DB_task_Reserve;
import com.example.saintgobain.service.ReserveService;
import com.example.saintgobain.service.WeChatService;
import com.example.saintgobain.utils.HttpUtils;



/**
 * @title 用户预约
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
@Controller
public class ReserveController {

	@Autowired
    private ReserveService reserveService;
	@Autowired
	private WeChatService weChatService;
	
	/**
	 * @title 用户提货预约
	 * @author jutao.cheng
	 * @param token  微信用户token
	 * @date 2021/08/16
	 * @version 1.0
	 * 
	 */
	@RequestMapping("/reserve")
	@ResponseBody
	public String reserve(String phone,String token,String order,String user,DB_task_Reserve db_task_reserve) {
		// 验证参数是否为空
		if (!HttpUtils.checkParameter(token)) {
			return HttpUtils.getParamterErrorMessage(Constants.HTTP_INVALIDATIN,null);
		}
		//验证token
		Boolean verify = weChatService.verify(token);
		if(!verify) {
			return HttpUtils.getParamterErrorMessage(Constants.HTTP_INVALIDATIN,null);
		}
		//提货预约
		String rederve = reserveService.rederve(phone,token,db_task_reserve);
		return rederve;
	}
}
