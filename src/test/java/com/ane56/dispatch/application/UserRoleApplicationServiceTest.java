package com.ane56.dispatch.application;

import java.util.List;

import com.ane56.bi.application.RoleApplicationService;
import com.ane56.bi.application.UserApplicationService;
import com.ane56.bi.application.command.role.CreateRoleCommand;
import com.ane56.bi.application.command.user.CreateUserCommand;
import com.ane56.bi.domain.user.Role;
import com.ane56.bi.domain.user.User;
import com.ane56.bi.domain.user.UserDescripter;
import com.ane56.bi.domain.user.UserRoleRepository;
import com.ane56.dispatch.AbstractTest;

public class UserRoleApplicationServiceTest extends AbstractTest {

	@Autowired
	private UserApplicationService userApplicationService;
	@Autowired
	private RoleApplicationService roleApplicationService;
	
	
	@Test
	public void testAdd(){
		
//		UserDescripter descripter = userApplicationService.createUser(
//				new CreateUserCommand("0033153", "huangjiu2", "1234562", "huangjiu2", "huangjiu2@ane56.com", "", ""));
//		
//		descripter.getUserId()
		
//		long roleId = roleApplicationService.create(new CreateRoleCommand("abc1", ""));
		
		
//		roleApplicationService.assign(Long.parseLong(descripter.getUserId()), roleId);
		
		
		
	}

	
	
	

}
