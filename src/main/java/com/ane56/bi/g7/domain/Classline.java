package com.ane56.bi.g7.domain;


import java.io.Serializable;
import java.util.List;

public class Classline implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5794792268334807794L;
	
	private String id;
	private String orgroot;
	private String orgcode;
	private String orgroot_name;
	private String orgcode_name;
	private String deleted;
	private String code;
	private String name;
	private String startsite;
	private String endsite;
	private String runtime;
	private String totalmileage;
	private String startsitecode;
	private String endsitecode;
	private String is_share;
	private String startSiteLngLat;
	private String endSiteLngLat;
	private String createtime;
	private String updatetime;
	private String postlinetype;
	private String classcode;
	private String endsite_run;
	private String postlinetype_id;
	private String startsiteid;
	private String endsite_mlg;
	private String carriage;
	private String orgname;
	private String endsiteid;
	private Object passinfo;
	private List<PassInfoData> passinfoList;
	
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
	public String getOrgcode() {
		return orgcode;
	}
	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}
	public String getOrgroot_name() {
		return orgroot_name;
	}
	public void setOrgroot_name(String orgroot_name) {
		this.orgroot_name = orgroot_name;
	}
	public String getOrgcode_name() {
		return orgcode_name;
	}
	public void setOrgcode_name(String orgcode_name) {
		this.orgcode_name = orgcode_name;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartsite() {
		return startsite;
	}
	public void setStartsite(String startsite) {
		this.startsite = startsite;
	}
	public String getEndsite() {
		return endsite;
	}
	public void setEndsite(String endsite) {
		this.endsite = endsite;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public String getTotalmileage() {
		return totalmileage;
	}
	public void setTotalmileage(String totalmileage) {
		this.totalmileage = totalmileage;
	}
	public String getStartsitecode() {
		return startsitecode;
	}
	public void setStartsitecode(String startsitecode) {
		this.startsitecode = startsitecode;
	}
	public String getEndsitecode() {
		return endsitecode;
	}
	public void setEndsitecode(String endsitecode) {
		this.endsitecode = endsitecode;
	}
	public String getIs_share() {
		return is_share;
	}
	public void setIs_share(String is_share) {
		this.is_share = is_share;
	}
	public String getStartSiteLngLat() {
		return startSiteLngLat;
	}
	public void setStartSiteLngLat(String startSiteLngLat) {
		this.startSiteLngLat = startSiteLngLat;
	}
	public String getEndSiteLngLat() {
		return endSiteLngLat;
	}
	public void setEndSiteLngLat(String endSiteLngLat) {
		this.endSiteLngLat = endSiteLngLat;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	public String getPostlinetype() {
		return postlinetype;
	}
	public void setPostlinetype(String postlinetype) {
		this.postlinetype = postlinetype;
	}
	public String getClasscode() {
		return classcode;
	}
	public void setClasscode(String classcode) {
		this.classcode = classcode;
	}
	public String getEndsite_run() {
		return endsite_run;
	}
	public void setEndsite_run(String endsite_run) {
		this.endsite_run = endsite_run;
	}
	public String getPostlinetype_id() {
		return postlinetype_id;
	}
	public void setPostlinetype_id(String postlinetype_id) {
		this.postlinetype_id = postlinetype_id;
	}
	public String getStartsiteid() {
		return startsiteid;
	}
	public void setStartsiteid(String startsiteid) {
		this.startsiteid = startsiteid;
	}
	public String getEndsite_mlg() {
		return endsite_mlg;
	}
	public void setEndsite_mlg(String endsite_mlg) {
		this.endsite_mlg = endsite_mlg;
	}
	public String getCarriage() {
		return carriage;
	}
	public void setCarriage(String carriage) {
		this.carriage = carriage;
	}
	public String getOrgname() {
		return orgname;
	}
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	public String getEndsiteid() {
		return endsiteid;
	}
	public void setEndsiteid(String endsiteid) {
		this.endsiteid = endsiteid;
	}
	public void setPassinfo(Object passinfo) {
		this.passinfo = passinfo;
	}
	public Object getPassinfo() {
		return passinfo;
	}
	public List<PassInfoData> getPassinfoList() {
		return passinfoList;
	}
	public void setPassinfoList(List<PassInfoData> passinfoList) {
		this.passinfoList = passinfoList;
	}
	
}
