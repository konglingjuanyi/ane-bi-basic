package com.ane56.bi.g7.domain;


import java.io.Serializable;

public class PassInfoData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -155701203347258958L;

	/**
	 * 站点ID，唯一标示
	 */
	private String id;	
	/**
	 * 顶级机构编号
	 */
	private String orgroot;
	/**
	 * 班线ID
	 */
	private String lineid;
	/**
	 * 站点ID
	 */
	private String siteid;	
	/**
	 *站序 
	 */
	private String order;	
	/**
	 * 站点运行时间
	 */
	private String runtime;	
	/**
	 * 站点停留时间
	 */
	private String staytime;	
	/**
	 * 始终点标志
	 */
	private String szflag;	
	/**
	 * 运行里程
	 */
	private String tomiles;	
	/**
	 * 站点名称
	 */
	private String name;	
	/**
	 * 站点纬度
	 */
	private String lat;	
	/**
	 * 站点经度
	 */
	private String lng;	
	/**
	 * 
	 */
	private String passSiteLngLat;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrgroot() {
		return orgroot;
	}
	public void setOrgroot(String orgroot) {
		this.orgroot = orgroot;
	}
	public String getLineid() {
		return lineid;
	}
	public void setLineid(String lineid) {
		this.lineid = lineid;
	}
	public String getSiteid() {
		return siteid;
	}
	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public String getStaytime() {
		return staytime;
	}
	public void setStaytime(String staytime) {
		this.staytime = staytime;
	}
	public String getSzflag() {
		return szflag;
	}
	public void setSzflag(String szflag) {
		this.szflag = szflag;
	}
	public String getTomiles() {
		return tomiles;
	}
	public void setTomiles(String tomiles) {
		this.tomiles = tomiles;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getPassSiteLngLat() {
		return passSiteLngLat;
	}
	public void setPassSiteLngLat(String passSiteLngLat) {
		this.passSiteLngLat = passSiteLngLat;
	}

}
