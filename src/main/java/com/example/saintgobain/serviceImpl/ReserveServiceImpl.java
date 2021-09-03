package com.example.saintgobain.serviceImpl;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.example.saintgobain.Constants;
import com.example.saintgobain.entity.DB_WeChat;
import com.example.saintgobain.entity.DB_task_List;
import com.example.saintgobain.entity.DB_task_Reserve;
import com.example.saintgobain.mapper.ReserveMapper;
import com.example.saintgobain.mapper.WeChatMapper;
import com.example.saintgobain.service.ReserveService;
import com.example.saintgobain.utils.HttpUtils;

/**
 * @title 用户提货预约
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
@Service
public class ReserveServiceImpl implements ReserveService {
	
	@Autowired
    private  ReserveMapper  reserveMapper;
	@Autowired
	private  WeChatMapper  weChatMapper;
	
	/**
	 * @title 用户提货预约
	 * @author jutao.cheng
	 * @date 2021/08/16
	 * @version 1.0
	 */
	@Override
	@Transactional
	public synchronized String rederve(String phone,String token,DB_task_Reserve db_task_reserve) {
		
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
		//查询司机是否还有执行的任务
		Map<String, Object> task = reserveMapper.seltask(db_task_list);
		if(task != null) {
			return HttpUtils.getParamterErrorMessage(Constants.TASK_HINT,null);
		}
		//保存任务信息
		reserveMapper.inserttask(db_task_list);
		//保存预约信息
		//DB_task_reserve db_task_reserve = new DB_task_reserve();
		db_task_reserve.setDriverid(String.valueOf(userMap.get("id")));
		db_task_reserve.setTaskid(String.valueOf(db_task_list.getId()));
		db_task_reserve.setReservation_date("2021-08-23");
		reserveMapper.inserttask_reserve(db_task_reserve);
		JSONObject data = new JSONObject();
        data.put("status", Constants.HTTP_SUCCESSCODE);
        data.put("name", "suecess");
        data.put("message", Constants.RESERVE_SUCCESS);
        data.put("data", db_task_reserve);
        return data.toString();
	}
}
