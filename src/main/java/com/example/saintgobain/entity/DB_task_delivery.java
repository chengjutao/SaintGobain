package com.example.saintgobain.entity;

/**
 * @title 用户装载类
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
public class DB_task_delivery {

	 /** id */
    private Integer id;
    /** 关联司机 */
    private String driverid;
    /** 任务id */
    private String taskid; 
    /** 类型（1，提货单，2，现场） */
    private String type;
    /** 图片名称 */
    private String photo_name;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPhoto_name() {
		return photo_name;
	}
	public void setPhoto_name(String photo_name) {
		this.photo_name = photo_name;
	}
	
    
    
}
