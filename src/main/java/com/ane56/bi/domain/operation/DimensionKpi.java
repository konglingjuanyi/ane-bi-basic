package com.ane56.bi.domain.operation;

import java.util.Date;

public class DimensionKpi implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1352734115715697504L;
	private int dimensionId; 
	private String dimensionName; 
	private int kpiId; 
	private int dimensionType; 
	private Date objDate; 
	private double targetValue; 
	private int departmentId; 
	private String departmentType; 
	private Date createTime; 
	private Date updateTime; 
	private String createdName; 
	private int createdId; 
	private int status;
	public int getDimensionId() {
		return dimensionId;
	}
	public void setDimensionId(int dimensionId) {
		this.dimensionId = dimensionId;
	}
	public String getDimensionName() {
		return dimensionName;
	}
	public void setDimensionName(String dimensionName) {
		this.dimensionName = dimensionName;
	}
	
	public int getKpiId() {
		return kpiId;
	}
	public void setKpiId(int kpiId) {
		this.kpiId = kpiId;
	}
	public int getDimensionType() {
		return dimensionType;
	}
	public void setDimensionType(int dimensionType) {
		this.dimensionType = dimensionType;
	}
	public Date getObjDate() {
		return objDate;
	}
	public void setObjDate(Date objDate) {
		this.objDate = objDate;
	}
	public double getTargetValue() {
		return targetValue;
	}
	public void setTargetValue(double targetValue) {
		this.targetValue = targetValue;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentType() {
		return departmentType;
	}
	public void setDepartmentType(String departmentType) {
		this.departmentType = departmentType;
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
	public String getCreatedName() {
		return createdName;
	}
	public void setCreatedName(String createdName) {
		this.createdName = createdName;
	}
	public int getCreatedId() {
		return createdId;
	}
	public void setCreatedId(int createdId) {
		this.createdId = createdId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
