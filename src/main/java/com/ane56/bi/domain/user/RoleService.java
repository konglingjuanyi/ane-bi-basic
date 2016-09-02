package com.ane56.bi.domain.user;

import java.util.List;

import com.ane56.bi.domain.AssertionConcern;

public class RoleService extends AssertionConcern {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRoleRepository userRoleRepository;

	public long create(String name, String remark) {
		Role role = this.roleRepository().findByName(name);
		this.assertArgumentTrue(role == null, "The role [" + name + "] is exist.");
		Role newRole = new Role(name, remark, RoleType.DEFAULT);
		this.roleRepository().add(newRole);
		return newRole.getId();
	}

	public void assign(long userId, long roleId) {

		User user = this.userRepository().findById(userId);
		Role role = this.roleRepository().findById(roleId);
		
		this.assertArgumentNotNull(user, "The user [" + userId + "] is required.");
		this.assertArgumentNotNull(role, "The role [" + roleId + "] is required.");
		
		List<UserRole> userRoles = this.userRoleRepository().findBy(userId, roleId);
		if (userRoles == null || userRoles.isEmpty()) {
			this.userRoleRepository().insert(new UserRole(userId, roleId));
		}
	}

	private RoleRepository roleRepository() {
		return this.roleRepository;
	}

	private UserRoleRepository userRoleRepository() {
		return this.userRoleRepository;
	}

	private UserRepository userRepository() {
		return this.userRepository;
	}

}
