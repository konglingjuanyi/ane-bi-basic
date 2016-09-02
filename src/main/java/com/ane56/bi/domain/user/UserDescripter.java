package com.ane56.bi.domain.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The account data transfer object that will return to clien when a user login
 * successfully
 *
 * @author apple
 *
 */
public class UserDescripter implements Serializable {

	private static final long serialVersionUID = 1L;
	private String userId;
	private String number;
	private String username;
	private String avatarUrl;
	private long expires;
	private List<String> roles;

	public UserDescripter(String userId, String number, String username, String avatarUrl, List<String> roles , long expires) {
		super();
		this.userId = userId;
		this.number = number;
		this.username = username;
		this.avatarUrl = avatarUrl;
		this.expires = expires;
		this.roles = roles;
	}

	protected UserDescripter() {
		super();
		this.roles = new ArrayList<>();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String accountId) {
		this.userId = accountId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public long getExpires() {
		return expires;
	}

	public void setExpires(long expires) {
		this.expires = expires;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public boolean isEmpty() {
		return StringUtils.isBlank(this.userId);
	}

	public boolean isEnabled() {
		return !StringUtils.isBlank(this.userId);
	}

	@Override
	public int hashCode() {
		int hashCodeValue = +(45217 * 269) + this.getUserId().hashCode();
		return hashCodeValue;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof UserDescripter) {
			UserDescripter dto = (UserDescripter) obj;
			return this.getUserId().equals(dto.getUserId());
		}
		return false;
	}

	public boolean hasRoles(String firstRoleTypes, String... restRoleTypes) {
		Set<String> requiredRoles = new HashSet<String>();
		requiredRoles.add(firstRoleTypes);

		for (String roleTyRole : restRoleTypes) {
			requiredRoles.add(roleTyRole);
		}
		return this.roles.containsAll(requiredRoles);
	}

	public boolean hasRoleInRoles(String... roleTypes) {
		for (String roleType : roleTypes) {
			if (this.roles.contains(roleType)) {
				return true;
			}
		}
		return false;
	}

	public static UserDescripter nullUserDescripter() {
		return new UserDescripter();
	}

}
