package com.example.saintgobain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.saintgobain.Constants;
import com.example.saintgobain.entity.DB_task_Approach;
import com.example.saintgobain.service.ApproachService;
import com.example.saintgobain.service.WeChatService;
import com.example.saintgobain.utils.HttpUtils;



/**
 * @title 用户进场
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
@Controller
public class ApproachController {

	@Autowired
    private ApproachService approachService;
	@Autowired
	private WeChatService weChatService;
	
	/**
	 * @title 用户进场
	 * @author jutao.cheng
	 * @param token  微信用户token
	 * @date 2021/08/16
	 * @version 1.0
	 * 
	 */
	@RequestMapping("/approach")
	@ResponseBody
	public String approach(String phone,String token,DB_task_Approach db_task_Approach) {
		// 验证参数是否为空
		if (!HttpUtils.checkParameter(token)) {
			return HttpUtils.getParamterErrorMessage(Constants.HTTP_INVALIDATIN,null);
		}
		//验证token
		Boolean verify = weChatService.verify(token);
		if(!verify) {
			return HttpUtils.getParamterErrorMessage(Constants.HTTP_INVALIDATIN,null);
		}
		//签到
		String rederve = approachService.approach(phone,token,db_task_Approach);
		return rederve;
	}
}
