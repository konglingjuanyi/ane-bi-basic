package com.ane56.bi.domain.basic;

import java.util.Date;

public class OrgBrnchClfc {
	private String orgBrnchId;//组织机构ID
	private String orgBrnchLvlCd;//组织机构等级代码
	private String clfcTypeCd;//分类类型代码,分拨类型
	private String clfcDtldCd;//分类详细代码，分拨功能
	private String crtUserId;//创建用户ID
	private Date crtTime;//创建时间
	private String crtAppSysId;//创建应用系统ID
	private String modfUserId;//修改用户ID
	private Date modfTime;//修改时间
	private String modfAppSysId;//修改应用系统ID
	private String siteSrvTypeCd;//网点服务类型代码
	private String dlvryModeCd;//配送方式代码
	private String statFlag;//是否统计
	
	public String getOrgBrnchId() {
		return orgBrnchId;
	}
	public void setOrgBrnchId(String orgBrnchId) {
		this.orgBrnchId = orgBrnchId;
	}
	public String getOrgBrnchLvlCd() {
		return orgBrnchLvlCd;
	}
	public void setOrgBrnchLvlCd(String orgBrnchLvlCd) {
		this.orgBrnchLvlCd = orgBrnchLvlCd;
	}
	public String getClfcTypeCd() {
		return clfcTypeCd;
	}
	public void setClfcTypeCd(String clfcTypeCd) {
		this.clfcTypeCd = clfcTypeCd;
	}
	public String getClfcDtldCd() {
		return clfcDtldCd;
	}
	public void setClfcDtldCd(String clfcDtldCd) {
		this.clfcDtldCd = clfcDtldCd;
	}
	public String getCrtUserId() {
		return crtUserId;
	}
	public void setCrtUserId(String crtUserId) {
		this.crtUserId = crtUserId;
	}
	public Date getCrtTime() {
		return crtTime;
	}
	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}
	public String getCrtAppSysId() {
		return crtAppSysId;
	}
	public void setCrtAppSysId(String crtAppSysId) {
		this.crtAppSysId = crtAppSysId;
	}
	public String getModfUserId() {
		return modfUserId;
	}
	public void setModfUserId(String modfUserId) {
		this.modfUserId = modfUserId;
	}
	public Date getModfTime() {
		return modfTime;
	}
	public void setModfTime(Date modfTime) {
		this.modfTime = modfTime;
	}
	public String getModfAppSysId() {
		return modfAppSysId;
	}
	public void setModfAppSysId(String modfAppSysId) {
		this.modfAppSysId = modfAppSysId;
	}
	public String getSiteSrvTypeCd() {
		return siteSrvTypeCd;
	}
	public void setSiteSrvTypeCd(String siteSrvTypeCd) {
		this.siteSrvTypeCd = siteSrvTypeCd;
	}
	public String getDlvryModeCd() {
		return dlvryModeCd;
	}
	public void setDlvryModeCd(String dlvryModeCd) {
		this.dlvryModeCd = dlvryModeCd;
	}
	public String getStatFlag() {
		return statFlag;
	}
	public void setStatFlag(String statFlag) {
		this.statFlag = statFlag;
	}
	
}
