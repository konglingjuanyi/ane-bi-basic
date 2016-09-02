package com.ane56.bi.domain.operation;

import java.util.Date;

import com.ane56.bi.domain.Entity;

public class PlanTime extends Entity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6034913536407140700L;
	private int operationId;
	private int siteId;
	private String siteName;
	private String carTypeName;
	private int carType;
	private double unloadCarTime;
	private double loadCarTime;
	private Date createTime;
	private Date updateTime;
	private int createdId;
	private String createdName;
	private int status;
	public int getOperationId() {
		return operationId;
	}
	public void setOperationId(int operationId) {
		this.operationId = operationId;
	}
	public int getSiteId() {
		return siteId;
	}
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getCarTypeName() {
		return carTypeName;
	}
	public void setCarTypeName(String carTypeName) {
		this.carTypeName = carTypeName;
	}
	public int getCarType() {
		return carType;
	}
	public void setCarType(int carType) {
		this.carType = carType;
	}
	public double getUnloadCarTime() {
		return unloadCarTime;
	}
	public void setUnloadCarTime(double unloadCarTime) {
		this.unloadCarTime = unloadCarTime;
	}
	public double getLoadCarTime() {
		return loadCarTime;
	}
	public void setLoadCarTime(double loadCarTime) {
		this.loadCarTime = loadCarTime;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
