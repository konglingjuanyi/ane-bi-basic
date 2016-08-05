package com.ane56.bi.application.command.role;

public class CreateRoleCommand {

	private String name;
	private String remark;

	public CreateRoleCommand(String name, String remark) {
		super();
		this.name = name;
		this.remark = remark;
	}

	public String getName() {
		return name;
	}

	public String getRemark() {
		return remark;
	}

}
