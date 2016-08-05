package com.ane56.bi.domain.user;

import java.util.Date;

import com.ane56.bi.domain.Entity;
import com.ane56.bi.port.adapter.utils.IdUtils;

/**
 * 类描述:用户角色关联类
 * @author hanyong
 */
public class UserRole extends Entity {

	private static final long serialVersionUID = 1L;
	private long userId;
	private long roleId;
	private Date created;

	public UserRole() {
	}

	public UserRole(long userId, long roleId) {
		super();
		this.setId(IdUtils.id());
		this.userId = userId;
		this.roleId = roleId;
		this.created = new Date();
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
