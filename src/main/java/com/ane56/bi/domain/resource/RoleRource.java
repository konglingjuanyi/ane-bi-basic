package com.ane56.bi.domain.resource;

import java.util.Date;

import com.ane56.bi.port.adapter.utils.IdUtils;

/**
 * 类描述:角色权限关联类
 * @author hanyong
 */
public class RoleRource {

	private String id;
	private String roleid;//角色ID
	private String sourseid;//权限ID
	private Date createtime;//创建时间
	private Date updatetime;//修改时间

	public RoleRource() {
	}

	public RoleRource(String roleid, String sourseid) {
		super();
		this.id = IdUtils.id4str();
		this.roleid = roleid;
		this.sourseid = sourseid;
		this.createtime = new Date();
		this.updatetime = new Date();
	}
	
	public RoleRource(String roleid){
		super();
		this.roleid = roleid;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getSourseid() {
		return sourseid;
	}

	public void setSourseid(String sourseid) {
		this.sourseid = sourseid;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
}
