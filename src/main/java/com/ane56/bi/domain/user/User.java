package com.ane56.bi.domain.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.ane56.bi.domain.Entity;
import com.ane56.bi.port.adapter.utils.IdUtils;

public class User extends Entity {

	private static final long serialVersionUID = 1L;
	private String number;
	private String username;
	private String password;
	private String nikename;
	private String avatarUrl;
	private String email;
	private String idNumber;
	private String phoneNumber;
	private String remark;
	private Date created;
	private Date updated;
	private boolean status;

	public User() {
	}

	public User(String number, String username, String password, String nikename, String email, String phoneNumber,
			String avatarUrl) {
		super();
		this.setId(IdUtils.id());
		this.number = number;
		this.username = username;
		this.password = password;
		this.nikename = nikename;
		this.avatarUrl = avatarUrl;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.created = new Date();
		this.updated = new Date();
		this.enable();
	}

	public void update(String username, String password, String nikename) {
		this.username = username;
		this.password = password;
		this.nikename = nikename;
	}

	public void changePassword(String newPassword) {
		this.assertArgumentEquals(this.password, newPassword, "is same for new password!");
		this.setPassword(newPassword);
	}

	public boolean isEnable() {
		return this.status;
	}

	public void enable() {
		this.setStatus(true);
	}

	public void disable() {
		this.setStatus(false);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNikename() {
		return nikename;
	}

	public void setNikename(String nikename) {
		this.nikename = nikename;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public UserDescripter descripter() {
		if (this.getId() == 0 || !isEnable()) {
			return UserDescripter.nullUserDescripter();
		}
		return new UserDescripter(this.getId() + "", number, username, avatarUrl, new ArrayList<String>(),
				System.currentTimeMillis() + TimeUnit.DAYS.toMillis(10));
	}

}
