package com.example.saintgobain.serviceImpl;




import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.example.saintgobain.Constants;
import com.example.saintgobain.entity.DB_WeChat;
import com.example.saintgobain.entity.DB_task_List;
import com.example.saintgobain.entity.DB_task_Load;
import com.example.saintgobain.mapper.LoadMapper;
import com.example.saintgobain.mapper.ReserveMapper;
import com.example.saintgobain.mapper.WeChatMapper;
import com.example.saintgobain.service.LoadService;
import com.example.saintgobain.utils.HttpUtils;

/**
 * @title 用户装载
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
@Service
public class LoadServiceImpl implements LoadService {
	
	@Autowired
    private  ReserveMapper  reserveMapper;
	@Autowired
	private  WeChatMapper  weChatMapper;
	@Autowired
	private  LoadMapper  loadMapper;
	/**
	 * @title 用户进场开始装货
	 * @author jutao.cheng
	 * @date 2021/08/16
	 * @version 1.0
	 */
	@Override
	@Transactional
	public String start(String phone, String token, DB_task_Load db_task_Load) {
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
		db_task_Load.setDriverid(String.valueOf(userMap.get("id")));
		db_task_Load.setTaskid(String.valueOf(task.get("id")));
		db_task_Load.setStart_load_time("2021-08-23");
		//查询是否已经开始装货
		Map<String,Object> signinMap = loadMapper.selectstartload(db_task_Load);
		if (signinMap == null) {
			//保存开始装载任务
			loadMapper.insertstartload(db_task_Load);
		}
		JSONObject data = new JSONObject();
        data.put("status", Constants.HTTP_SUCCESSCODE);
        data.put("name", "suecess");
        data.put("message", Constants.SIGNIN_SUCCESS);
        data.put("data", db_task_Load);
        return data.toString();
	}
	/**
	 * @title 用户进场结束装载
	 * @author jutao.cheng
	 * @date 2021/08/16
	 * @version 1.0
	 */
	@Override
	@Transactional
	public String end(String phone, String token, DB_task_Load db_task_Load) {
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
				db_task_Load.setDriverid(String.valueOf(userMap.get("id")));
				db_task_Load.setTaskid(String.valueOf(task.get("id")));
				db_task_Load.setStart_load_time("2021-08-23");
				//查询是否已经结束装货
				Map<String,Object> signinMap = loadMapper.selectstartload(db_task_Load);
				if (signinMap == null) {
					//保存结束装载任务
					loadMapper.updateendload(db_task_Load);
				}
				JSONObject data = new JSONObject();
		        data.put("status", Constants.HTTP_SUCCESSCODE);
		        data.put("name", "suecess");
		        data.put("message", Constants.SIGNIN_SUCCESS);
		        data.put("data", db_task_Load);
		        return data.toString();
	}
	

}
