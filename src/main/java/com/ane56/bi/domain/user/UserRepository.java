package com.ane56.bi.domain.user;

import java.util.List;

public interface UserRepository {

	void add(User user);

	void save(User user);

	void remove(User user);

	List<User> allUsers();

	Pagination<User> allUsers(int start, int limit);

	User findById(long userId);

	User findByUsername(String username);

	User findByNumber(String number);

	User findByEmail(String emailAddress);

	User findByPhoneNumber(String phoneNumber);

}
