package com.ane56.bi.application.command.user;

import com.ane56.bi.domain.user.AuthticationType;

public class AuthenticationCommand {

	private String username;
	private String password;
	private AuthticationType type;

	public AuthenticationCommand(String username, String password, AuthticationType type) {
		super();
		this.username = username;
		this.password = password;
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public AuthticationType getType() {
		return type;
	}

}
