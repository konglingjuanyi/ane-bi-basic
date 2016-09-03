package com.ane56.bi.port.adapter.web.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ane56.bi.application.UserApplicationService;
import com.ane56.bi.application.command.user.CreateUserCommand;
import com.ane56.bi.application.command.user.UpdateUserCommand;
import com.ane56.bi.domain.user.User;
import com.ane56.bi.port.adapter.rest.ResourceResponseSupport;
import com.ane56.bi.port.adapter.rest.RestResultResponse;
import com.ane56.bi.port.adapter.utils.PageUtils;
import com.ane56.bi.port.adapter.web.resource.form.UserForm;
import com.ane56.db.mybatis.core.Pagination;

@RestController
public class UserExampleResources extends ResourceResponseSupport {

	@Autowired
	private UserApplicationService userApplicationService;

	@RequestMapping(value = "/api/users", method = RequestMethod.GET)
	public RestResultResponse allUsers() {
		return this.buildSuccessRestResultResponse(this.userApplicationService.allUsers());
	}

	@RequestMapping(value = "/api/users2", method = RequestMethod.GET)
	public RestResultResponse allUsers2(@RequestParam(value = "p", required = false, defaultValue = "1") int page,
			@RequestParam(value = "s", required = false, defaultValue = "2") int size) {
		Pagination<User> users = this.userApplicationService.allUsers(PageUtils.getOffset(page, size), size);
		return this.buildSuccessRestResultResponse(users);
	}

	@RequestMapping(value = "/api/user/{userId}", method = RequestMethod.GET)
	public RestResultResponse getUser(@PathVariable long userId) {
		return this.buildSuccessRestResultResponse(this.userApplicationService.getUser(userId));
	}

	@RequestMapping(value = "/api/user", method = RequestMethod.POST)
	public RestResultResponse createUser(@RequestBody UserForm aForm) {

//		this.userApplicationService
//				.add(new CreateUserCommand(aForm.getUsername(), aForm.getPassword(), aForm.getNikename()));

		return this.buildSuccessRestResultResponse();
	}

	@RequestMapping(value = "/api/user/{userId}", method = RequestMethod.PUT)
	public RestResultResponse updateUser(@PathVariable long userId, @RequestBody UserForm aForm) {
		this.userApplicationService
				.update(new UpdateUserCommand(userId, aForm.getUsername(), aForm.getPassword(), aForm.getNikename()));
		return this.buildSuccessRestResultResponse();
	}

	@RequestMapping(value = "/api/user/{userId}", method = RequestMethod.DELETE)
	public RestResultResponse removeUser(@PathVariable long userId) {
		this.userApplicationService.remove(userId);
		return this.buildSuccessRestResultResponse();
	}

}
