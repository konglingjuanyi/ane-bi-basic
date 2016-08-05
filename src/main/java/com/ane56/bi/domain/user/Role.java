package com.ane56.bi.domain.user;

import java.util.Date;

import com.ane56.bi.domain.Entity;
import com.ane56.bi.port.adapter.utils.IdUtils;

public class Role extends Entity {

	private static final long serialVersionUID = 1L;
	private String name;
	private String remark;
	private Date created;
	private Date updated;
	private RoleType type;
	private boolean status;

	public Role() {
	}

	public Role(String name, String remark, RoleType type) {
		super();
		this.setId(IdUtils.id());
		this.name = name;
		this.type = type;
		this.remark = remark;
		this.created = new Date();
		this.updated = new Date();
		this.enable();
	}

	public void update(String name, String remark) {
		this.setName(name);
		this.setRemark(remark);
		this.setUpdated(new Date());
	}

	public void enable() {
		this.setStatus(true);
	}

	public void disable() {
		this.setStatus(false);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RoleType getType() {
		return type;
	}

	public void setType(RoleType type) {
		this.type = type;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}