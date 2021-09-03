package com.example.saintgobain.entity;

/**
 * @title 用户预约类
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
public class DB_task_Reserve {

	 /** id */
    private Integer id;
    /** 关联司机 */
    private String driverid;
    /** 关联任务 */
    private String taskid;
    /** 预约编号 */
    private String reservation_number; 
    /**  TO号 */
    private String to_number;
    /**  DO号 */
    private String od_number;
    /**  预约时间 */
    private String reservation_date;
    /**  时间段 */
    private String period_time;
    /**  产品 */
    private String product;
    /**  T数量 */
    private String number;
    /**  T仓库 */
    private String ware;
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
	public String getTo_number() {
		return to_number;
	}
	public void setTo_number(String to_number) {
		this.to_number = to_number;
	}
	public String getOd_number() {
		return od_number;
	}
	public void setOd_number(String od_number) {
		this.od_number = od_number;
	}
	public String getReservation_date() {
		return reservation_date;
	}
	public void setReservation_date(String reservation_date) {
		this.reservation_date = reservation_date;
	}
	public String getPeriod_time() {
		return period_time;
	}
	public void setPeriod_time(String period_time) {
		this.period_time = period_time;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getWare() {
		return ware;
	}
	public void setWare(String ware) {
		this.ware = ware;
	}
	
    
    
    
}
