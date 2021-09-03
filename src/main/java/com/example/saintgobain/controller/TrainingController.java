package com.example.saintgobain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.saintgobain.Constants;
import com.example.saintgobain.entity.DB_task_Training;
import com.example.saintgobain.service.TrainingService;
import com.example.saintgobain.service.WeChatService;
import com.example.saintgobain.utils.HttpUtils;



/**
 * @title 用户任务进场须知培训和疫情表
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
@Controller
@RequestMapping("/training")
public class TrainingController {

	@Autowired
	private WeChatService weChatService;
	@Autowired
	private TrainingService trainingService;
	
	/**
	 * @title 用户进场须知
	 * @author jutao.cheng
	 * @param token  微信用户token
	 * @date 2021/08/16
	 * @version 1.0
	 * 
	 */
	@RequestMapping("/comeinnotice")
	@ResponseBody
	public String comeinnotice(String phone,String token,DB_task_Training db_task_Training) {
		// 验证参数是否为空
		if (!HttpUtils.checkParameter(token)) {
			return HttpUtils.getParamterErrorMessage(Constants.HTTP_INVALIDATIN,null);
		}
		//验证token
		Boolean verify = weChatService.verify(token);
		if(!verify) {
			return HttpUtils.getParamterErrorMessage(Constants.HTTP_INVALIDATIN,null);
		}
		//进场须知
		String rederve = trainingService.comeinnotice(phone,token,db_task_Training);
		return rederve;
	}
	/**
	 * @title 用户疫情阅读
	 * @author jutao.cheng
	 * @param token  微信用户token
	 * @date 2021/08/16
	 * @version 1.0
	 * 
	 */
	@RequestMapping("/epidemic")
	@ResponseBody
	public String epidemic(String phone,String token,DB_task_Training db_task_Training) {
		// 验证参数是否为空
		if (!HttpUtils.checkParameter(token)) {
			return HttpUtils.getParamterErrorMessage(Constants.HTTP_INVALIDATIN,null);
		}
		//验证token
		Boolean verify = weChatService.verify(token);
		if(!verify) {
			return HttpUtils.getParamterErrorMessage(Constants.HTTP_INVALIDATIN,null);
		}
		//疫情阅读
		String rederve = trainingService.epidemic(phone,token,db_task_Training);
		return rederve;
	}
	/**
	 * @title 用户承诺书
	 * @author jutao.cheng
	 * @param token  微信用户token
	 * @date 2021/08/16
	 * @version 1.0
	 * 
	 */
	@RequestMapping("/promise")
	@ResponseBody
	public String promise(String phone,String token,DB_task_Training db_task_Training) {
		// 验证参数是否为空
		if (!HttpUtils.checkParameter(token)) {
			return HttpUtils.getParamterErrorMessage(Constants.HTTP_INVALIDATIN,null);
		}
		//验证token
		Boolean verify = weChatService.verify(token);
		if(!verify) {
			return HttpUtils.getParamterErrorMessage(Constants.HTTP_INVALIDATIN,null);
		}
		//承诺书
		String rederve = trainingService.promise(phone,token,db_task_Training);
		return rederve;
	}
}
