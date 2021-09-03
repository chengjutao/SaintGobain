package com.example.saintgobain.serviceImpl;



import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.example.saintgobain.Constants;
import com.example.saintgobain.entity.DB_WeChat;
import com.example.saintgobain.mapper.WeChatMapper;
import com.example.saintgobain.utils.HttpUtils;
import com.example.saintgobain.service.WeChatService;

/**
 * @title 用户登录接口实现类
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
@Service
public class WeChatServiceImpl implements WeChatService {
	
	@Autowired
    private WeChatMapper weChatMapper;
	/**
	 * @title 用户登录生成token接口
	 * @author jutao.cheng
	 * @param db_Users 用户数据 User
	 * @return 返回信息{"token":"urvkowes0PPv3MLfsB3RblMOOQN1bHEGSdjcFe5sK4SBbDUoxDuhoawcXJGpy8iz","account":"13604992376"}
	 * @date 2021/08/16
	 * @version 1.0
	 * 
	 */
	@Override
	public String login(String code,String phone) {
		// 拼接url
				StringBuilder urlBuilder = new StringBuilder(Constants.URL_ADDRESS);
				urlBuilder.append("?appid=" + "wxc2934a1fe4ab6d04");
				urlBuilder.append("&secret=" + "df0e8ae381fda652758fc691aa92ab85");
				urlBuilder.append("&js_code=" + code);
				urlBuilder.append("&grant_type=authorization_code");
				try {
					HttpClient client = HttpClientBuilder.create().build();
					HttpGet httpGet = new HttpGet(urlBuilder.toString());
					HttpResponse response = client.execute(httpGet);
					// 判断返回状态是否为200
					if (response.getStatusLine().getStatusCode() == 200) {
						HttpEntity resultEntity = response.getEntity();
						String contentString = EntityUtils.toString(resultEntity, "UTF-8");
						// 解析json
						JSONObject jsonObject = (JSONObject) JSONObject.parse(contentString);
						String sessionKeys = jsonObject.get("session_key").toString();
						String openId = jsonObject.get("openid").toString();
						// 校验openId是否有效
						if (!StringUtils.hasText(openId) && !StringUtils.hasText(sessionKeys)) {
							return HttpUtils.getParamterErrorMessage(Constants.HTTP_FAIL, null);
						}
						//登录成功，自定义skey
						String token = sessionKeys+openId;
						//保存token
						DB_WeChat weChat = new DB_WeChat();
						weChat.setToken(token);
						weChat.setPhone(phone);
						//验证phone是否存在，存在则修改token，否则保存新增
						List<Map<String, Object>> verifyphone = weChatMapper.verifyphone(phone);
						//新增
						if(verifyphone.size()==0) {
							weChatMapper.insertdriver(weChat);
						}else {
						//修改
							weChatMapper.updatedriver(weChat);
						}
				         JSONObject data = new JSONObject();
				         data.put("status", 200);
				         data.put("name", "suecess");
				         data.put("message", "成功");
				         data.put("token", token);
				         return data.toString();
					} else {
						return HttpUtils.getParamterErrorMessage("请求硬件设备接口报错:{" + urlBuilder + "}", "系统异常");
					}
				} catch (Exception e) {
					return HttpUtils.getParamterErrorMessage(
							"请求硬件设备连接异常:{" + urlBuilder + "}" + "详细信息:{" + e.getMessage() + "}", "系统异常");
				}
	}
	
	/**
	 * @title 用户token验证
	 * @author jutao.cheng
	 * @param token 用户数据 token
	 * @date 2021/08/16
	 * @version 1.0
	 * @throws Exception 
	 * 
	 */
	@Override
	public Boolean verify(String token) {
		//查询token是否存在
		Integer count = weChatMapper.WeChatverify(token);
		if (count>0) {
			return true;	
		}
			return false;
	}
}
