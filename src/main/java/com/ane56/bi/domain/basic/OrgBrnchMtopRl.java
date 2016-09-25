package com.ane56.bi.domain.basic;

import java.util.Date;

public class OrgBrnchMtopRl {
	private String orgBrnchId;//组织机构ID
	private String orgBrnchLvlCd;//组织机构等级代码
	private String crtUserId;//创建用户ID
	private Date crtTime;//创建时间
	private String crtAppSysId;//创建应用系统ID
	private String modfUserId;//修改用户ID
	private Date modfTime;//修改时间
	private String modfAppSysId;//修改应用系统ID
	private String suprMtopId;//上级组织机构ID
	private String suprMtopLvlCd;//上级组织机构等级代码
	private String orgBrnchNm;//组织机构名称
	
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
	public String getSuprMtopId() {
		return suprMtopId;
	}
	public void setSuprMtopId(String suprMtopId) {
		this.suprMtopId = suprMtopId;
	}
	public String getSuprMtopLvlCd() {
		return suprMtopLvlCd;
	}
	public void setSuprMtopLvlCd(String suprMtopLvlCd) {
		this.suprMtopLvlCd = suprMtopLvlCd;
	}
	public String getOrgBrnchNm() {
		return orgBrnchNm;
	}
	public void setOrgBrnchNm(String orgBrnchNm) {
		this.orgBrnchNm = orgBrnchNm;
	}
	
}
