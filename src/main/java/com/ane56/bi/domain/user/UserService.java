package com.ane56.bi.domain.user;

import java.util.ArrayList;
import java.util.List;

import com.ane56.bi.domain.AssertionConcern;

public class UserService extends AssertionConcern {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserRoleRepository userRoleRepository;
	@Autowired
	private EncryptionService encryptionService;
	


	public UserDescripter create(String number, String username, String password, String nickename, String emailAddress,
			String phoneNumber, String avatarUrl) {
		String encryptionPassoword = this.encrypt(password);
		User user = new User(number, username, encryptionPassoword, nickename, emailAddress, phoneNumber, avatarUrl);
		this.userRepository().add(user);
		return user.descripter();
	}

	public void resetPassword(long userId, String oldPassword, String newPassword) {
		User user = this.userRepository().findById(userId);
		this.assertArgumentNotNull(user, "The user [" + userId + "] not exist !");

		String entryptionPassword1 = this.encrypt(oldPassword);
		this.assertArgumentTrue(!entryptionPassword1.equals(user.getPassword()), "The user password error.");

		user.changePassword(this.encrypt(newPassword));
		this.userRepository().save(user);
	}

	public void resetPassword(long userId, String newPassword) {
		User user = this.userRepository().findById(userId);
		if (user == null) {
			throw new IllegalArgumentException("The user [" + userId + "] not exist !");
		}
		user.changePassword(this.encrypt(newPassword));
		this.userRepository().save(user);
	}

	public UserDescripter authentication(String username, String password, AuthticationType loginType) {
		User user = null;
		if (loginType.isUsername()) {
			user = this.userRepository().findByEmail(username);
		} else if (loginType.isNumber()) {
			user = this.userRepository().findByNumber(username);
		} else if (loginType.isPhoneNumber()) {
			user = this.userRepository().findByPhoneNumber(username);
		} else if (loginType.isEmail()) {
			user = this.userRepository().findByEmail(username);
		}

		if (user == null) {
			return UserDescripter.nullUserDescripter();
		}
		String entryptionPassword = this.encrypt(password);
		if (!entryptionPassword.equals(user.getPassword())) {
			return UserDescripter.nullUserDescripter();
		}
		return getUserRoles(user.getId(), user.descripter());
	}

	public UserDescripter getUserDescriptor(long userId) {
		User user = this.userRepository().findById(userId);
		if (user == null) {
			return UserDescripter.nullUserDescripter();
		}
		return getUserRoles(userId, user.descripter());
	}
	
	public UserDescripter getUserDescriptor(User user) {
		if (user == null) {
			return UserDescripter.nullUserDescripter();
		}
		return getUserRoles(user.getId(), user.descripter());
	}

	private UserDescripter getUserRoles(long userId, UserDescripter descriptor) {
		if (descriptor.isEmpty()) {
			return descriptor;
		}
		List<Role> roles = this.userRoleRepository().findRolesByUserId(userId);
		List<String> results = new ArrayList<>();
		for (Role role : roles) {
			results.add(role.getName());
		}
		descriptor.setRoles(results);
		return descriptor;
	}

	private String encrypt(String value) {
		return this.encryptionService().encryptedValue(value);
	}

	private UserRepository userRepository() {
		return this.userRepository;
	}

	private EncryptionService encryptionService() {
		return this.encryptionService;
	}

	private UserRoleRepository userRoleRepository() {
		return this.userRoleRepository;
	}

}
