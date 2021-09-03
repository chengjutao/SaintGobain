package com.example.saintgobain.utils;

import java.security.MessageDigest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.example.saintgobain.Constants;

/**
 * @title 请求验证
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */

public class HttpUtils {

	/**
	 * @title 判断参数是否为空
	 * @author jutao.cheng
	 * @param parameter 参数
	 * @return Boolean true/false
	 * @date 2021/08/16
	 * @version 1.0
	 */
	public static Boolean checkParameter(String parameter) {
		/** 验证用户Token信息 */
		if (!StringUtils.hasText(parameter)) {
			return false;
		}
		return true;
	}

	/**
	 * @title 获取error messages
	 * @author jutao.cheng
	 * @param message 参数
	 * @return 提示错误信息
	 * @date 2021/08/16
	 * @version 1.0
	 */
	public static String getParamterErrorMessage(String message, String messaageType) {
		JSONObject errorMessage = new JSONObject();
		JSONObject data = new JSONObject();
		data.put("status", 401);
		data.put("name", "ApplicationError");
		if(HttpUtils.checkParameter(messaageType)) {
			data.put("name", messaageType);
		}
		data.put("message", message);
		errorMessage.put("error", data);
		return data.toString();
	}

	
	/**
	 * @title 生成token
	 * @author jutao.cheng
	 * @param username 账号
	 * @param password 密码
	 * @return token
	 * @date 2021/08/17
	 * @version 1.0
	 */
	public static String token (String username,String password){
		  
        String token = "";
        try {
            //过期时间
            Date date = new Date(System.currentTimeMillis()+Constants.EXPIRE_DATE);
            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC512(Constants.TOKEN_SECRET);
            //设置头部信息
            Map<String,Object> header = new HashMap<>();
            header.put("typ","JWT");
            header.put("alg","HS512");
            //携带username，password信息，生成签名
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("username",username)
                    .withClaim("password",password).withExpiresAt(date)
                    .sign(algorithm);
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
        return token;
    }
	 /**
     * @title 验证 token
     * @param token token 
     * @return 返回 是否验证成功
     * @date 2021/08/16
	 * @version 1.0
     */
     public static boolean verify(String token){
         try {
             Algorithm algorithm = Algorithm.HMAC512(Constants.TOKEN_SECRET);
             JWTVerifier verifier = JWT.require(algorithm).build();
             DecodedJWT jwt = verifier.verify(token);
             return true;
         }catch (Exception e){
             return  false;
         }
     }
     

     /**
 	 * @title  获取十六进制字符串形式的MD5摘要
 	 * @author jutao.cheng
     * @date 2021/08/16
	 * @version 1.0
     */
     public static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            StringBuilder buf = new StringBuilder(bs.length * 2);
            for(byte b : bs) { // 使用String的format方法进行转换
                buf.append(String.format("%02x", new Integer(b & 0xff)));
            }
            return buf.toString();
        } catch (Exception e) {
            return null;
        }
    }
     public static void main(String[] args) {
    	 Date date = new Date(System.currentTimeMillis()+Constants.EXPIRE_DATE);
    	 System.out.println(date);
	}
     /**
      * 返回 成功 messages
      * 
      * @return Json
      */
     public static String getsuccessMessage() {
         JSONObject suecessMessage = new JSONObject();
         JSONObject data = new JSONObject();
         data.put("status", 200);
         data.put("name", "suecess");
         data.put("message", "成功");
         suecessMessage.put("data", data);
         return suecessMessage.toString();
     }
}
