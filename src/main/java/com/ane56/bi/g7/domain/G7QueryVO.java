package com.ane56.bi.g7.domain;



public class G7QueryVO implements java.io.Serializable{
	private static final long serialVersionUID = -8192834914918131237L;
	private String id;
	private String name;
	private String orgnum;
	private String classcode;
	private String likecode;
	private int pathid;
	private String startsite;
	private String endsite;
	private String is_share;
	private String is_passall;
	private int  deleted;
	private String updatetimeGe;
	private String  updatetimeLe;
	private int pageNo;
	private int pageSize;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrgnum() {
		return orgnum;
	}
	public void setOrgnum(String orgnum) {
		this.orgnum = orgnum;
	}
	public String getClasscode() {
		return classcode;
	}
	public void setClasscode(String classcode) {
		this.classcode = classcode;
	}
	public String getLikecode() {
		return likecode;
	}
	public void setLikecode(String likecode) {
		this.likecode = likecode;
	}
	public int getPathid() {
		return pathid;
	}
	public void setPathid(int pathid) {
		this.pathid = pathid;
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
	public String getIs_share() {
		return is_share;
	}
	public void setIs_share(String is_share) {
		this.is_share = is_share;
	}
	public String getIs_passall() {
		return is_passall;
	}
	public void setIs_passall(String is_passall) {
		this.is_passall = is_passall;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	public String getUpdatetimeGe() {
		return updatetimeGe;
	}
	public void setUpdatetimeGe(String updatetimeGe) {
		this.updatetimeGe = updatetimeGe;
	}
	public String getUpdatetimeLe() {
		return updatetimeLe;
	}
	public void setUpdatetimeLe(String updatetimeLe) {
		this.updatetimeLe = updatetimeLe;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	

}
