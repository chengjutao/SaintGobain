package com.example.saintgobain.entity;

/**
 * @title 用户实体类
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
public class DB_task_List {

	 /** id */
    private Integer id;
    /** 关联司机 */
    private String driverid;
    /** 任务状态（0，预约，1签到，2培训，3进场，4装运，5离场） */
    private String task_status; 
    /**  任务执行状态0执行，1停止（有且只有一个任务在执行） */
    private String status;
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
	public String getTask_status() {
		return task_status;
	}
	public void setTask_status(String task_status) {
		this.task_status = task_status;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
    
    
    
}
