package com.ane56.bi.application;

import java.util.List;

import com.ane56.bi.application.command.user.AuthenticationCommand;
import com.ane56.bi.application.command.user.CreateUserCommand;
import com.ane56.bi.application.command.user.UpdateUserCommand;
import com.ane56.bi.domain.AssertionConcern;
import com.ane56.bi.domain.user.User;
import com.ane56.bi.domain.user.UserDescripter;
import com.ane56.bi.domain.user.UserRepository;
import com.ane56.bi.domain.user.UserService;

@Service
public class UserApplicationService extends AssertionConcern {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserService userService;

	@Transactional
	public UserDescripter createUser(CreateUserCommand aCommand) {
		UserDescripter userDescripter = this.userService().create(aCommand.getNumber(), aCommand.getUsername(),
				aCommand.getPassword(), aCommand.getNikename(), aCommand.getEmailAddress(), aCommand.getPhoneNumber(),
				aCommand.getAvatarUrl());
		return userDescripter;
	}

	public void update(UpdateUserCommand aCommand) {
		User user = this.userRepository().findById(aCommand.getId());
		user.update(aCommand.getUsername(), aCommand.getPassword(), aCommand.getNikename());
		this.userRepository().save(user);
	}

	public void resetPassword() {
	}

	public void disabled(long userId) {
		User user = this.userRepository().findById(userId);
		this.assertArgumentNotNull(user, "The user [" + userId + "] is required.");
		this.userRepository().remove(user);
	}

	public void remove(long userId) {
		User user = this.userRepository().findById(userId);
		this.userRepository().remove(user);
	}

	public User getUser(long userId) {
		return this.userRepository().findById(userId);
	}

	@Transactional(readOnly = true)
	public UserDescripter authentication(AuthenticationCommand aCommand) {
		return this.userService().authentication(aCommand.getUsername(), aCommand.getPassword(), aCommand.getType());
	}

	public List<User> allUsers() {
		return this.userRepository().allUsers();
	}

	public Pagination<User> allUsers(int start, int limit) {
		return this.userRepository().allUsers(start, limit);
	}

	private UserRepository userRepository() {
		return this.userRepository;
	}

	private UserService userService() {
		return this.userService;
	}

}
