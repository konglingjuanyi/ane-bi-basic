package com.ane56.dispatch.application;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ane56.bi.application.RoleApplicationService;
import com.ane56.bi.application.command.role.CreateRoleCommand;
import com.ane56.dispatch.AbstractTest;

public class RoleApplicationServiceTest extends AbstractTest{
	@Autowired
	private RoleApplicationService roleApplicationService;
	@Test
	public void addRole(){
//		roleApplicationService.add(new CreateRoleCommand("员工", 1, "员工"));
	}

}
