package com.example.saintgobain;

/**
 * @title   常量类
 * @author  jutao.cheng
 * @date    2021/08/16
 * @version 1.0
 */
public class Constants {

	//账号为空
	public static final String HTTP_ACCOUNT = "登录帐号为空！"; 
	//密码为空
	public static final String HTTP_PASSWORD = "登录密码为空！";
	
	//登录失败401
	public static final String HTTP_FAILCODE = "401";
	//登录失败
	public static final String HTTP_FAIL  = "登录失败！";
	//登录账号错误
	public static final String HTTP_ACCOUNTERROR  = "登录账号错误！";
	//登录失败 fail
	public static final String HTTP_FAILNAME  = "fail";
	
	//登录成功200
	public static final String HTTP_SUCCESSCODE  = "200";
	//登录成功
	public static final String HTTP_SUCCESS  = "登录成功！";
	//登录成功
	public static final String HTTP_SUCCESSNAME  = "success";
	
	//状态码
	public static final String STATUSCODE  = "statusCode";
	//状态名
	public static final String NAME  = "name";
	//信息
	public static final String MESSAGE  = "message";
	//token
	public static final String TOKEN  = "token";
	//token秘钥，内容随意目的加密
	public static final String TOKEN_SECRET = "ZCfasfhuaUUHufguGuwu2020BQWE";
	//设置 token 过期时间
	public static final long EXPIRE_DATE=30*60*100000;
	//微信登录获取session_key、openid地址
	public static final String URL_ADDRESS="https://api.weixin.qq.com/sns/jscode2session";
	//微信小程序appid
	public static final String APP_ID="wx635236d145b7314f";
	//微信小程序appsecret密钥
	public static final String APP_SECRET="54dbcaa053ac328100f21467353b9aa8";
	//登录失效
	public static final String HTTP_INVALIDATIN ="登录失效，重新登录！";
	//任务提示
	public static final String  TASK_HINT="当前有正在执行的任务！";
	//任务提示
	public static final String  RESERVE_SUCCESS="预约成功！";
	//签到提示
	public static final String  SIGNIN_SUCCESS="签到成功！";
	//已经签到提示
	public static final String  SIGNIN_SUCCESS2="已经签到，无需重复签到！";
	//进场须知提示
	public static final String  COMEIN_SUCCESS="提交成功！";
	//疫情阅读提示
	public static final String  READ_SUCCESS="确认成功！";
	//进场提示
	public static final String  APPROACH_SUCCESS="进场成功！";
	//离场提示
	public static final String  LEAVE_SUCCESS="离场成功！";
	//交付提示
	public static final String  DELIVERY_SUCCESS="交付成功！";
	
}
