package com.ane56.bi.domain.resource;

import java.util.Date;

import com.ane56.bi.domain.Entity;

public class Resource extends Entity {
	private static final long serialVersionUID = 1L;
	private String resourceId;
	private String name;
	private String alias;
	private String parengId;
	private String path;
	private ResourceType type;
	private String remark;
	private Date created;
	private Date updated;

	public Resource() {
		super();
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getParengId() {
		return parengId;
	}

	public void setParengId(String parengId) {
		this.parengId = parengId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public ResourceType getType() {
		return type;
	}

	public void setType(ResourceType type) {
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

}
