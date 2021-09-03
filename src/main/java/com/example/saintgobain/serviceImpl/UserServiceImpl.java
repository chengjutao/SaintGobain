package com.example.saintgobain.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.example.saintgobain.Constants;
import com.example.saintgobain.entity.DB_User;
import com.example.saintgobain.mapper.UserMapper;
import com.example.saintgobain.service.UserService;
import com.example.saintgobain.utils.HttpUtils;

/**
 * @title 用户登录接口实现类
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
    private UserMapper userMapper;
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
	public String birthtoken(DB_User db_user) {
		//生成token信息
		 String token = HttpUtils.token(db_user.getAccount(), db_user.getPassword());
		 	//验证生成token是否为空
	        if (!HttpUtils.checkParameter(token)) {
	            return HttpUtils.getParamterErrorMessage(Constants.HTTP_FAIL,null);
	        }
	        // 判断 如果账号不存在，返回账号错误
	       if (userMapper.verifyAccount(db_user).size() == 0) {
	            return HttpUtils.getParamterErrorMessage(Constants.HTTP_ACCOUNTERROR,null);
	       }
	        //md5密码加密失败
	        String md5 = HttpUtils.md5Hex(db_user.getPassword());
	        if (!HttpUtils.checkParameter(md5)) {
	            return HttpUtils.getParamterErrorMessage(Constants.HTTP_FAIL,null);
	        }
	        db_user.setPassword(md5);
	        // 判断 账号 密码 是否正确
	       DB_User db_User = userMapper.verifyAccountPassword(db_user);
	        if (db_User != null) {
	            JSONObject data = new JSONObject();
	            db_User.setToken(token);
	            //存储修改登录token
	            userMapper.updLoginToken(db_User);
	            data.put(Constants.STATUSCODE, Constants.HTTP_SUCCESSCODE);
	            data.put(Constants.NAME, Constants.HTTP_SUCCESSNAME);
	            data.put(Constants.MESSAGE,  Constants.HTTP_SUCCESS);
	            data.put(Constants.TOKEN, token);
	            return data.toString();
	        }
	        return HttpUtils.getParamterErrorMessage(Constants.HTTP_FAIL,null);
	}
}
