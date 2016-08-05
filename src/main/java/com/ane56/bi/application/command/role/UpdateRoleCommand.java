package com.ane56.bi.application.command.role;

public class UpdateRoleCommand {

	private long id;
	private String name;
	private String remark;

	public UpdateRoleCommand(long id, String name, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.remark = remark;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRemark() {
		return remark;
	}

}
