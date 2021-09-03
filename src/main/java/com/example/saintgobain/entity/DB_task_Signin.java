package com.example.saintgobain.entity;

/**
 * @title 用户签到类
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
public class DB_task_Signin {

	 /** id */
    private Integer id;
    /** 关联司机 */
    private String driverid;
    /** 任务id */
    private String taskid; 
    /**  签到号 */
    private String reservation_number;
    /**  签到时间 */
    private String signin_time;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDriverid() {
		return driverid;
	}
	public void setDriverid(String driverid) {
		this.driverid = driverid;
	}
	public String getTaskid() {
		return taskid;
	}
	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}
	public String getReservation_number() {
		return reservation_number;
	}
	public void setReservation_number(String reservation_number) {
		this.reservation_number = reservation_number;
	}
	public String getSignin_time() {
		return signin_time;
	}
	public void setSignin_time(String signin_time) {
		this.signin_time = signin_time;
	}
	
	
    
    
    
}
