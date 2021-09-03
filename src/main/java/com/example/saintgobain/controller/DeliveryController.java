package com.example.saintgobain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.saintgobain.Constants;
import com.example.saintgobain.entity.DB_task_delivery;
import com.example.saintgobain.service.DeliveryService;
import com.example.saintgobain.service.WeChatService;
import com.example.saintgobain.utils.HttpUtils;



/**
 * @title 用户交付
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
@Controller
public class DeliveryController {

	@Autowired
    private DeliveryService deliveryService;
	@Autowired
	private WeChatService weChatService;
	
	/**
	 * @title 用户交付
	 * @author jutao.cheng
	 * @param token  微信用户token
	 * @date 2021/08/16
	 * @version 1.0
	 * 
	 */
	@RequestMapping("/delivery")
	@ResponseBody
	public String delivery(String phone,String token,DB_task_delivery db_task_delivery) {
		// 验证参数是否为空
		if (!HttpUtils.checkParameter(token)) {
			return HttpUtils.getParamterErrorMessage(Constants.HTTP_INVALIDATIN,null);
		}
		//验证token
		Boolean verify = weChatService.verify(token);
		if(!verify) {
			return HttpUtils.getParamterErrorMessage(Constants.HTTP_INVALIDATIN,null);
		}
		//交付
		String rederve = deliveryService.delivery(phone,token,db_task_delivery);
		return rederve;
	}
}
