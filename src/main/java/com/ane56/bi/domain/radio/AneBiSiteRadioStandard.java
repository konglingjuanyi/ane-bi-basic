package com.ane56.bi.domain.radio;

import java.util.Date;

import com.ane56.bi.domain.Entity;

public class AneBiSiteRadioStandard extends Entity{
	private static final long serialVersionUID = 1L;
	private Double radio;//比例标准值
	private String createBy;//创建人
	private Date createTime;//创建时间
	private String updateBy;//修改人
	private Date updateTime;//修改时间
	
	public Double getRadio() {
		return radio;
	}
	public void setRadio(Double radio) {
		this.radio = radio;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
