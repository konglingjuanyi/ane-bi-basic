package com.ane56.bi.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ane56.bi.application.command.role.CreateRoleCommand;
import com.ane56.bi.application.command.role.UpdateRoleCommand;
import com.ane56.bi.domain.AssertionConcern;
import com.ane56.bi.domain.resource.Resource;
import com.ane56.bi.domain.user.Role;
import com.ane56.bi.domain.user.RoleRepository;
import com.ane56.bi.domain.user.RoleService;
import com.ane56.bi.domain.user.UserRoleRepository;
import com.ane56.db.mybatis.core.Pagination;

@Service
public class RoleApplicationService extends AssertionConcern {

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRoleRepository userRoleRepository;
	@Autowired
	private RoleService roleService;

	public long create(CreateRoleCommand aCommand) {
		return this.roleService().create(aCommand.getName(), aCommand.getRemark());
	}

	public void update(UpdateRoleCommand aCommand) {
		Role role = this.roleRepository().findById(aCommand.getId());
		this.assertArgumentNotNull(role, "The role [" + aCommand.getName() + "] is required.");
		role.update(aCommand.getName(), aCommand.getRemark());
		this.roleRepository().save(role);
	}

	public void assign(long userId, long roleId) {
		this.roleService().assign(userId, roleId);
	}

	public void unassign(long userId, long roleId) {
		this.userRoleRepository().removeBy(userId, roleId);
	}

	public void disable(long roleId) {
		Role role = this.roleRepository().findById(roleId);
		role.disable();
		this.roleRepository().save(role);
	}

	public void remove(long roleId) {
		Role role = this.roleRepository().findById(roleId);
		this.roleRepository().remove(role);
	}

	/**
	 * 根据id查询角色
	 * 
	 * @param id
	 * @return
	 */
	public Role getRole(long roleId) {
		Role role = this.roleRepository().findById(roleId);
		return role;

	}

	/**
	 * 根据角色名查询角色（验证角色是否重复）
	 * 
	 * @param name
	 * @return
	 */
	public Role findName(String name) {
		Role role = this.roleRepository().findByName(name);
		return role;
	}

	public List<Role> allRoles() {
		return this.roleRepository().allRoles();
	}

	/**
	 * 根据条件查询角色
	 * 
	 * @param start
	 * @param limit
	 * @param name
	 * @return
	 */
	public Pagination<Role> allRoles(int start, int limit, String name) {
		return this.roleRepository().allRoles(start, limit, name);
	}

	

	/**
	 * 查询所有资源
	 * 
	 * @return
	 */
	public List<Resource> queryAllSourses() {
		// List<Resource> resorceList =
		// resourceApplicationService.allResources();
		// return resorceList;
		return null;
	}

	private RoleRepository roleRepository() {
		return this.roleRepository;
	}

	private UserRoleRepository userRoleRepository() {
		return this.userRoleRepository;
	}

	private RoleService roleService() {
		return this.roleService;
	}
}
