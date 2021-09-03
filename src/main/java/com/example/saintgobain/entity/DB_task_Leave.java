package com.example.saintgobain.entity;

/**
 * @title 用户装载类
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
public class DB_task_Leave {

	 /** id */
    private Integer id;
    /** 关联司机 */
    private String driverid;
    /** 任务id */
    private String taskid; 
    /** 离开时间 */
    private String leave_time;
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
	public String getLeave_time() {
		return leave_time;
	}
	public void setLeave_time(String leave_time) {
		this.leave_time = leave_time;
	}
	
    
    
}
