package com.example.saintgobain.entity;

/**
 * @title 用户培训类
 * @author jutao.cheng
 * @date 2021/08/16
 * @version 1.0
 */
public class DB_task_Training {

	 /** id */
    private Integer id;
    /** 关联司机 */
    private String driverid;
    /** 任务id */
    private String taskid; 
    /** 本人已阅读 */
    private String whether_read;
    /** 是否新冠肺炎 */
    private String whether_new_crown;
    /** 是否有感染症状 */
    private String whether_symptom;
    /** 是否接触感染肺炎人员*/
    private String whether_touch;
    /** 是否途径疫情地区 */
    private String whether_pass_area;
    /** 是否接触经过上述地区的朋友亲人 */
    private String whether_touch_personnel;
    /** 姓名 */
    private String driver_name;
    /** 手机号 */
    private String phone;
    /** 所属公司 */
    private String owned_company;
    /** 籍贯省 */
    private String hometown_province;
    /** 居住省 */
    private String reside_province;
    /** 籍贯市 */
    private String hometown_city;
    /** 居住市 */
    private String reside_city;
    /** 身份证号 */
    private String identity_umber;
    /** 行驶证图片上传名称 */
    private String driving_license;
    /** 驾驶证图片上传名称 */
    private String driver_license;
    
    
	public String getDriver_name() {
		return driver_name;
	}
	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getOwned_company() {
		return owned_company;
	}
	public void setOwned_company(String owned_company) {
		this.owned_company = owned_company;
	}
	public String getHometown_province() {
		return hometown_province;
	}
	public void setHometown_province(String hometown_province) {
		this.hometown_province = hometown_province;
	}
	public String getReside_province() {
		return reside_province;
	}
	public void setReside_province(String reside_province) {
		this.reside_province = reside_province;
	}
	public String getHometown_city() {
		return hometown_city;
	}
	public void setHometown_city(String hometown_city) {
		this.hometown_city = hometown_city;
	}
	public String getReside_city() {
		return reside_city;
	}
	public void setReside_city(String reside_city) {
		this.reside_city = reside_city;
	}
	public String getIdentity_umber() {
		return identity_umber;
	}
	public void setIdentity_umber(String identity_umber) {
		this.identity_umber = identity_umber;
	}
	public String getDriving_license() {
		return driving_license;
	}
	public void setDriving_license(String driving_license) {
		this.driving_license = driving_license;
	}
	public String getDriver_license() {
		return driver_license;
	}
	public void setDriver_license(String driver_license) {
		this.driver_license = driver_license;
	}
	public String getWhether_new_crown() {
		return whether_new_crown;
	}
	public void setWhether_new_crown(String whether_new_crown) {
		this.whether_new_crown = whether_new_crown;
	}
	public String getWhether_symptom() {
		return whether_symptom;
	}
	public void setWhether_symptom(String whether_symptom) {
		this.whether_symptom = whether_symptom;
	}
	public String getWhether_touch() {
		return whether_touch;
	}
	public void setWhether_touch(String whether_touch) {
		this.whether_touch = whether_touch;
	}
	public String getWhether_pass_area() {
		return whether_pass_area;
	}
	public void setWhether_pass_area(String whether_pass_area) {
		this.whether_pass_area = whether_pass_area;
	}
	public String getWhether_touch_personnel() {
		return whether_touch_personnel;
	}
	public void setWhether_touch_personnel(String whether_touch_personnel) {
		this.whether_touch_personnel = whether_touch_personnel;
	}
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
	public String getWhether_read() {
		return whether_read;
	}
	public void setWhether_read(String whether_read) {
		this.whether_read = whether_read;
	}
	
	
    
    
    
}
