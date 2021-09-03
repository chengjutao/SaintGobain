package com.example.saintgobain.entity;

/**
 * @title 用户装载类
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
public class DB_task_Load {

	 /** id */
    private Integer id;
    /** 关联司机 */
    private String driverid;
    /** 任务id */
    private String taskid; 
    /** 开始装载时间 */
    private String start_load_time;
    /** 结束装载时间 */
    private String end_load_time;
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
	public String getStart_load_time() {
		return start_load_time;
	}
	public void setStart_load_time(String start_load_time) {
		this.start_load_time = start_load_time;
	}
	public String getEnd_load_time() {
		return end_load_time;
	}
	public void setEnd_load_time(String end_load_time) {
		this.end_load_time = end_load_time;
	}
	
    
    
    
}
