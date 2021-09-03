package com.example.saintgobain.serviceImpl;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.example.saintgobain.Constants;
import com.example.saintgobain.entity.DB_WeChat;
import com.example.saintgobain.entity.DB_task_List;
import com.example.saintgobain.entity.DB_task_Signin;
import com.example.saintgobain.mapper.ReserveMapper;
import com.example.saintgobain.mapper.SignInMapper;
import com.example.saintgobain.mapper.WeChatMapper;
import com.example.saintgobain.service.SignInService;
import com.example.saintgobain.utils.HttpUtils;

/**
 * @title 用户签到
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
@Service
public class SignInServiceImpl implements SignInService {
	
	@Autowired
    private  ReserveMapper  reserveMapper;
	@Autowired
	private  WeChatMapper  weChatMapper;
	@Autowired
	private  SignInMapper  signinMapper;
	

/**
 * @title 用户签到
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
	@Override
	@Transactional
	public synchronized String signin(String phone, String token, DB_task_Signin db_task_Signin) {
				//查询用户登录信息
				DB_WeChat db_WeChat = new DB_WeChat();
				db_WeChat.setPhone(phone);
				db_WeChat.setToken(token);
				Map<String, Object> userMap = weChatMapper.seldriver(db_WeChat);
				if (userMap == null) {
					return HttpUtils.getParamterErrorMessage(Constants.HTTP_INVALIDATIN,null);
				}
				DB_task_List db_task_list = new DB_task_List();
				db_task_list.setDriverid(String.valueOf(userMap.get("id")));
				//查询司机执行的任务信息
				Map<String, Object> task = reserveMapper.seltask(db_task_list);
				db_task_Signin.setDriverid(String.valueOf(userMap.get("id")));
				db_task_Signin.setTaskid(String.valueOf(task.get("id")));
				db_task_Signin.setSignin_time("2021-08-23");
				//查询是否已经签到
				Map<String,Object> signinMap = signinMapper.selectsignin(db_task_Signin);
				if (signinMap != null) {
					return HttpUtils.getParamterErrorMessage(Constants.SIGNIN_SUCCESS2,null);
				}
				//保存签到任务
				signinMapper.insertsignin(db_task_Signin);
				JSONObject data = new JSONObject();
		        data.put("status", Constants.HTTP_SUCCESSCODE);
		        data.put("name", "suecess");
		        data.put("message", Constants.SIGNIN_SUCCESS);
		        data.put("data", db_task_Signin);
		        return data.toString();
	}

}
