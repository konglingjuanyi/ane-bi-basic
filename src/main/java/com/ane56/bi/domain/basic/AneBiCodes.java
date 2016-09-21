package com.ane56.bi.domain.basic;

import java.util.Date;

public class AneBiCodes{
	private static final long serialVersionUID = 1L;
	private long id;
	private String codeType;//字典项类型
	private String codeName;//字典项名称
	private Date createTime;//系统生成时间
	private Date updateTime;//修改时间
	private String createdName;//操作人
	private String description;//中文描述
	private int codeValue;//字典值
	
	public void update(String codeType,String description,String codeName,int codeValue){
		this.codeType = codeType;
		this.description = description;
		this.codeName =codeName;
		this.codeValue = codeValue;
		this.updateTime= new Date();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCodeType() {
		return codeType;
	}
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCodeValue() {
		return codeValue;
	}
	public void setCodeValue(int codeValue) {
		this.codeValue = codeValue;
	}
	
}
