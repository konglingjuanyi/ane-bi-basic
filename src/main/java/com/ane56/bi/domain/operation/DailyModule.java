package com.ane56.bi.domain.operation;

import java.util.Date;

public class DailyModule implements java.io.Serializable {
	private static final long serialVersionUID = -5428401308175907910L;
	private int moduleId; 
	private String moduleName; 
	private int moduleOrder; 
	private int createdId; 
	private String createdName; 
	private int updatedId; 
	private String updatedName; 
	private Date createTime; 
	private Date updateTime; 
	private int status;
	public int getModuleId() {
		return moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	public int getModuleOrder() {
		return moduleOrder;
	}
	public void setModuleOrder(int moduleOrder) {
		this.moduleOrder = moduleOrder;
	}
	public int getCreatedId() {
		return createdId;
	}
	public void setCreatedId(int createdId) {
		this.createdId = createdId;
	}
	public String getCreatedName() {
		return createdName;
	}
	public void setCreatedName(String createdName) {
		this.createdName = createdName;
	}
	public int getUpdatedId() {
		return updatedId;
	}
	public void setUpdatedId(int updatedId) {
		this.updatedId = updatedId;
	}
	public String getUpdatedName() {
		return updatedName;
	}
	public void setUpdatedName(String updatedName) {
		this.updatedName = updatedName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
