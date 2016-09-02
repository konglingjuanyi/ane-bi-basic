package com.ane56.bi.port.adapter.persistence;

import java.util.List;

import com.ane56.bi.domain.user.Role;
import com.ane56.bi.domain.user.RoleRepository;
@Component
public class MybatisRoleRepository extends SpringMybatisRepositorySupport implements RoleRepository{
	
	@Override
	public void add(Role role) {
		this.repository().insert(role);
	}

	@Override
	public void save(Role role) {
		this.repository().update(role);
	}

	@Override
	public void remove(Role role) {
		this.repository().delete(role);
	}


	@Override
	public Role findByName(String name) {
		Role role = this.repository().queryBy(new QueryBuilder(Role.class).eq("name", name).build());
		return role;
	}
	@Override
	public List<Role> allRoles() {
		return this.repository().query(new QueryBuilder(Role.class).build());
	}

	@Override
	public Pagination<Role> allRoles(int start, int limit,String name) {
		return this.repository().query(new QueryBuilder(Role.class).like("name", "%"+name+"%").build(), start, limit);
	}

	@Override
	public Role findById(long id) {
		return findByProp(Role.class, "id", id + "");
	}

}
