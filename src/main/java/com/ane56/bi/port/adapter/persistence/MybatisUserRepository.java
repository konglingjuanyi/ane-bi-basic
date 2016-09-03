package com.ane56.bi.port.adapter.persistence;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ane56.bi.domain.user.User;
import com.ane56.bi.domain.user.UserRepository;
import com.ane56.db.mybatis.core.Pagination;
import com.ane56.db.mybatis.query.QueryBuilder;

@Component
public class MybatisUserRepository extends SpringMybatisRepositorySupport implements UserRepository {

	@Override
	public void add(User user) {
		this.repository().insert(user);
	}

	@Override
	public void save(User user) {
		this.repository().update(user);
	}

	@Override
	public void remove(User user) {
		this.repository().delete(user);
	}

	@Override
	public User findById(long userId) {
		User user = this.repository().queryBy(new QueryBuilder(User.class).eq("id", userId).build());
		return user;
	}

	@Override
	public List<User> allUsers() {
		return this.repository().query(new QueryBuilder(User.class).build());
	}

	@Override
	public Pagination<User> allUsers(int start, int limit) {
		return this.repository().query(new QueryBuilder(User.class).build(), start, limit);
	}

	@Override
	public User findByUsername(String username) {
		return findByProp(User.class, "username", username);
	}

	@Override
	public User findByNumber(String number) {
		return findByProp(User.class, "number", number);
	}

	@Override
	public User findByEmail(String emailAddress) {
		return findByProp(User.class, "email", emailAddress);
	}

	@Override
	public User findByPhoneNumber(String phoneNumber) {
		return findByProp(User.class, "phoneNumber", phoneNumber);
	}

}
