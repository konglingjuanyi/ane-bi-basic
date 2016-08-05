package com.ane56.bi.application.command.user;

public class CreateUserCommand {

	private String number;
	private String username;
	private String password;
	private String nikename;
	private String emailAddress;
	private String phoneNumber;
	private String avatarUrl;

	public CreateUserCommand(String number, String username, String password, String nikename, String emailAddress,
			String phoneNumber, String avatarUrl) {
		super();
		this.number = number;
		this.username = username;
		this.password = password;
		this.nikename = nikename;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.avatarUrl = avatarUrl;
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

	public String getNumber() {
		return number;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

}
