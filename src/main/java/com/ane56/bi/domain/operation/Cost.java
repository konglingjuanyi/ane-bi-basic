package com.ane56.bi.domain.operation;

import java.util.Date;

public class Cost implements java.io.Serializable {
	
	private static final long serialVersionUID = 2233164805551848496L;
	private int costId; 
	private String costName; 
	private int costType; 
	private Date createTime; 
	private int sourceCode; 
	private int status;
	public int getCostId() {
		return costId;
	}
	public void setCostId(int costId) {
		this.costId = costId;
	}
	public String getCostName() {
		return costName;
	}
	public void setCostName(String costName) {
		this.costName = costName;
	}
	public int getCostType() {
		return costType;
	}
	public void setCostType(int costType) {
		this.costType = costType;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getSourceCode() {
		return sourceCode;
	}
	public void setSourceCode(int sourceCode) {
		this.sourceCode = sourceCode;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
