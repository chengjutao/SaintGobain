package com.example.saintgobain.serviceImpl;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.example.saintgobain.Constants;
import com.example.saintgobain.entity.DB_WeChat;
import com.example.saintgobain.entity.DB_task_Approach;
import com.example.saintgobain.entity.DB_task_List;
import com.example.saintgobain.mapper.ApproachMapper;
import com.example.saintgobain.mapper.ReserveMapper;
import com.example.saintgobain.mapper.WeChatMapper;
import com.example.saintgobain.service.ApproachService;
import com.example.saintgobain.utils.HttpUtils;

/**
 * @title 用户进场
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
@Service
public class ApproachServiceImpl implements ApproachService {
	
	@Autowired
    private  ReserveMapper  reserveMapper;
	@Autowired
	private  WeChatMapper  weChatMapper;
	@Autowired
	private  ApproachMapper  approachMapper;
	

/**
 * @title 用户进场
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
	@Override
	@Transactional
	public synchronized String approach(String phone, String token, DB_task_Approach db_task_Approach) {
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
				db_task_Approach.setDriverid(String.valueOf(userMap.get("id")));
				db_task_Approach.setTaskid(String.valueOf(task.get("id")));
				db_task_Approach.setArrive_time("2021-08-23");
				//查询是否已经签到
				Map<String,Object> approachMap = approachMapper.selectapproach(db_task_Approach);
				if (approachMap == null) {
					//保存进场须知信息
					approachMapper.insertapproach(db_task_Approach);
				}
				JSONObject data = new JSONObject();
		        data.put("status", Constants.HTTP_SUCCESSCODE);
		        data.put("name", "suecess");
		        data.put("message", Constants.APPROACH_SUCCESS);
		        data.put("data", db_task_Approach);
		        return data.toString();
	}

}
