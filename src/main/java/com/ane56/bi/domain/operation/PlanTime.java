package com.ane56.bi.domain.operation;

import java.util.Date;

import com.ane56.bi.domain.Entity;

public class PlanTime extends Entity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6034913536407140700L;
	private String siteId; 
	private String siteTypeCd; 
	private String veTypeCd; 
	private String crtUserId; 
	private Date crtTime;
	private String crtAppSysId; 
	private String modfUserId; 
	private Date modfTime; 
	private String modfAppSysId;
	private String shmtOpCtime;
	private String unldOpCtime; 
	private String validFlag;
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public String getSiteTypeCd() {
		return siteTypeCd;
	}
	public void setSiteTypeCd(String siteTypeCd) {
		this.siteTypeCd = siteTypeCd;
	}
	public String getVeTypeCd() {
		return veTypeCd;
	}
	public void setVeTypeCd(String veTypeCd) {
		this.veTypeCd = veTypeCd;
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
	public String getShmtOpCtime() {
		return shmtOpCtime;
	}
	public void setShmtOpCtime(String shmtOpCtime) {
		this.shmtOpCtime = shmtOpCtime;
	}
	public String getUnldOpCtime() {
		return unldOpCtime;
	}
	public void setUnldOpCtime(String unldOpCtime) {
		this.unldOpCtime = unldOpCtime;
	}
	public String getValidFlag() {
		return validFlag;
	}
	public void setValidFlag(String validFlag) {
		this.validFlag = validFlag;
	}
	
}
