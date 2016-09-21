package com.ane56.bi.domain.extraDays;

import java.util.Date;

import com.ane56.bi.domain.Entity;
import com.ane56.bi.port.adapter.utils.IdUtils;
import com.ane56.bi.port.adapter.utils.LetterUtils;

public class AneBiSiteExtraDays extends Entity{
	private static final long serialVersionUID = 1L;
	private String siteName;//网点名称
	private String sitePinyin;//网点拼音
	private String type;//类型
	private String siteProperty;//网点属性
	private String agingType;//时效类型
	private int extraDays;//额外天数
	private String memo;//备注
	private String createBy;//创建人
	private Date createTime;//创建时间
	private String updateBy;//修改人
	private Date updateTime;//修改时间
	
	public AneBiSiteExtraDays(){
		
	}
	
	public AneBiSiteExtraDays(String siteName,String siteProperty, String type,
			String agingType, int extraDays, String memo) {
		super();
		this.setId(IdUtils.id());
		this.siteName = siteName;
		this.sitePinyin= LetterUtils.getAllFirstLetter(siteName);
		this.type = type;
		this.siteProperty = siteProperty;
		this.agingType = agingType;
		this.extraDays = extraDays;
		this.memo = memo;
		this.createTime = new Date();
		this.updateTime= new Date();
	}

	public void update(String siteName,String siteProperty, String type,
			String agingType,int extraDays,String memo){
		this.siteName= siteName;
		this.sitePinyin= LetterUtils.getAllFirstLetter(siteName);
		this.siteProperty= siteProperty;
		this.type = type;
		this.agingType= agingType;
		this.extraDays= extraDays;
		this.memo= memo;
		this.updateTime= new Date();
	}
	
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getSitePinyin() {
		return sitePinyin;
	}
	public void setSitePinyin(String sitePinyin) {
		this.sitePinyin = sitePinyin;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSiteProperty() {
		return siteProperty;
	}
	public void setSiteProperty(String siteProperty) {
		this.siteProperty = siteProperty;
	}
	public String getAgingType() {
		return agingType;
	}
	public void setAgingType(String agingType) {
		this.agingType = agingType;
	}
	public int getExtraDays() {
		return extraDays;
	}
	public void setExtraDays(int extraDays) {
		this.extraDays = extraDays;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
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
