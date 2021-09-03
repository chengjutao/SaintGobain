package com.example.saintgobain.serviceImpl;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.example.saintgobain.Constants;
import com.example.saintgobain.entity.DB_WeChat;
import com.example.saintgobain.entity.DB_task_List;
import com.example.saintgobain.entity.DB_task_Training;
import com.example.saintgobain.mapper.ReserveMapper;
import com.example.saintgobain.mapper.TrainingMapper;
import com.example.saintgobain.mapper.WeChatMapper;
import com.example.saintgobain.service.TrainingService;
import com.example.saintgobain.utils.HttpUtils;

/**
 * @title 用户进场须知
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
@Service
public class TrainingServiceImpl implements TrainingService {
	
	@Autowired
    private  ReserveMapper  reserveMapper;
	@Autowired
	private  WeChatMapper  weChatMapper;
	@Autowired
	private  TrainingMapper  trainingMapper;
	
	/**
	 * @title 用户进场须知
	 * @author jutao.cheng
	 * @date 2021/08/16
	 * @version 1.0
	 */
	@Override
	@Transactional
	public synchronized String comeinnotice(String phone,String token,DB_task_Training db_task_Training) {
		
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
		db_task_Training.setDriverid(String.valueOf(userMap.get("id")));
		db_task_Training.setTaskid(String.valueOf(task.get("id")));
		//查询是否已经进场须知提交
		Map<String,Object> comeinMap = trainingMapper.selectcomein(db_task_Training);
		if (comeinMap == null) {
			//保存进场须知信息
			trainingMapper.inserttraining(db_task_Training);
		}
		JSONObject data = new JSONObject();
        data.put("status", Constants.HTTP_SUCCESSCODE);
        data.put("name", "suecess");
        data.put("message", Constants.COMEIN_SUCCESS);
        data.put("data", db_task_Training);
        return data.toString();
	}
	/**
	 * @title 用户疫情阅读
	 * @author jutao.cheng
	 * @date 2021/08/16
	 * @version 1.0
	 */
	@Override
	@Transactional
	public synchronized String epidemic(String phone, String token, DB_task_Training db_task_Training) {
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
				db_task_Training.setDriverid(String.valueOf(userMap.get("id")));
				db_task_Training.setTaskid(String.valueOf(task.get("id")));
				//查询是否已经进场须知，有修改
				Map<String,Object> comeinMap = trainingMapper.selectcomein(db_task_Training);
				if (comeinMap != null) {
					//修改进场须知信息
					db_task_Training.setId(Integer.valueOf(String.valueOf(comeinMap.get("id"))));
					trainingMapper.updateepidemic(db_task_Training);
				}
				JSONObject data = new JSONObject();
		        data.put("status", Constants.HTTP_SUCCESSCODE);
		        data.put("name", "suecess");
		        data.put("message", Constants.READ_SUCCESS);
		        data.put("data", db_task_Training);
		        return data.toString();
	}
	/**
	 * @title 用户承诺书
	 * @author jutao.cheng
	 * @date 2021/08/16
	 * @version 1.0
	 */
	@Override
	@Transactional
	public synchronized String promise(String phone, String token, DB_task_Training db_task_Training) {
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
		db_task_Training.setDriverid(String.valueOf(userMap.get("id")));
		db_task_Training.setTaskid(String.valueOf(task.get("id")));
		//查询是否已经进场须知，有修改
		Map<String,Object> comeinMap = trainingMapper.selectcomein(db_task_Training);
		if (comeinMap != null) {
			//修改进场须知信息
			db_task_Training.setId(Integer.valueOf(String.valueOf(comeinMap.get("id"))));
			trainingMapper.updatepromise(db_task_Training);
		}
		JSONObject data = new JSONObject();
		data.put("status", Constants.HTTP_SUCCESSCODE);
		data.put("name", "suecess");
		data.put("message", Constants.READ_SUCCESS);
		data.put("data", db_task_Training);
		return data.toString();
	}
}
