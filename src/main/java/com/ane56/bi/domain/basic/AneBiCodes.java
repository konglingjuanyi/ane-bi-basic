package com.ane56.bi.domain.basic;

import java.util.Date;

import com.ane56.bi.domain.Entity;

public class AneBiCodes extends Entity{
	private static final long serialVersionUID = 1L;
	private String codeType;//编码类型
	private String codeName;//编码名称
	private Date createTime;//系统生成时间
	private Date updateTime;//修改时间
	private String createdName;//操作人
	private String description;//中文描述
	
	public void update(String codeType,String description,String codeName){
		this.codeType = codeType;
		this.description = description;
		this.codeName =codeName;
		this.updateTime= new Date();
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
	
}
