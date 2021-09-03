package com.example.saintgobain.entity;

/**
 * @title 用户进场类
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
public class DB_task_Approach {

	 /** id */
    private Integer id;
    /** 关联司机 */
    private String driverid;
    /** 任务id */
    private String taskid; 
    /** 到达时间 */
    private String arrive_time;
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
	public String getArrive_time() {
		return arrive_time;
	}
	public void setArrive_time(String arrive_time) {
		this.arrive_time = arrive_time;
	}
    
    
    
}
