package com.ane56.bi.application.command.user;

public class UpdateUserCommand {

	private long id;
	private String username;
	private String password;
	private String nikename;

	public UpdateUserCommand(long id, String username, String password, String nikename) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nikename = nikename;
	}

	public long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getNikename() {
		return nikename;
	}

}
