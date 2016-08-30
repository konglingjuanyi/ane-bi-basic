package com.ane56.bi.domain.operation;

import java.util.Date;

public class TargetCost implements java.io.Serializable {
	private static final long serialVersionUID = -5464685234906378915L;
	private int targetId; 
	private String targetName; 
	private int incomeMark; 
	private int priceMark; 
	private int createdId; 
	private String createdName; 
	private int updatedId; 
	private String updatedName; 
	private Date createTime; 
	private Date updateTime; 
	private int status;
	public int getTargetId() {
		return targetId;
	}
	public void setTargetId(int targetId) {
		this.targetId = targetId;
	}
	public String getTargetName() {
		return targetName;
	}
	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}
	public int getIncomeMark() {
		return incomeMark;
	}
	public void setIncomeMark(int incomeMark) {
		this.incomeMark = incomeMark;
	}
	public int getPriceMark() {
		return priceMark;
	}
	public void setPriceMark(int priceMark) {
		this.priceMark = priceMark;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
