package com.ane56.bi.domain.basic;

import java.util.Date;

public class OrgBrnchQueryVO {
	private String orgBrnchId;// 组织机构ID
	private String orgBrnchLvlCd;// 组织机构等级代码
	private String crtUserId;// 创建用户ID
	private Date crtTime;// 创建时间
	private String crtAppSysId;// 创建应用系统ID
	private String modfUserId;// 修改用户ID
	private Date modfTime;// 修改时间
	private String modfAppSysId;// 修改应用系统ID
	private String suprMtopId;// 上级组织机构ID
	private String suprMtopLvlCd;// 上级组织机构等级代码
	private String orgBrnchNm;// 组织机构名称
	
	private String suprMtopNm;// 上级组织机构名称
	private String areaId;
	private String areaName;
	private String provinceId;
	private String provinceName;
	private String dictId;
	private String dictName;
	private String siteId;
	private String siteName;
	private String area;// 区域name+空格+区域id
	private String province;// 省区name+空格+省区id
	private String dict;// 大区name+空格+大区id
	private String site;// 分拨name+空格+分拨id
	
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
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getDictId() {
		return dictId;
	}
	public void setDictId(String dictId) {
		this.dictId = dictId;
	}
	public String getDictName() {
		return dictName;
	}
	public void setDictName(String dictName) {
		this.dictName = dictName;
	}
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getDict() {
		return dict;
	}
	public void setDict(String dict) {
		this.dict = dict;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getSuprMtopNm() {
		return suprMtopNm;
	}
	public void setSuprMtopNm(String suprMtopNm) {
		this.suprMtopNm = suprMtopNm;
	}
	
}
