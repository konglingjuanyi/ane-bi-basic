package com.ane56.bi.domain.user;

import java.util.List;

public interface RoleRepository {

	void add(Role role);

	void save(Role role);

	void remove(Role role);

	Role findById(long id);

	Role findByName(String name);

	List<Role> allRoles();

	Pagination<Role> allRoles(int start, int limit, String name);
}
