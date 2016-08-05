package com.ane56.dispatch.application;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ane56.bi.application.UserApplicationService;
import com.ane56.bi.application.command.user.CreateUserCommand;
import com.ane56.bi.domain.user.Role;
import com.ane56.bi.domain.user.User;
import com.ane56.bi.domain.user.UserRoleRepository;
import com.ane56.db.mybatis.Pagination;
import com.ane56.dispatch.AbstractTest;

public class UserApplicationServiceTest extends AbstractTest {

	@Autowired
	private UserApplicationService userApplicationService;
	@Autowired
	private UserRoleRepository userRoleRepository;

	// static {
	//
	// try {
	// String resource = "mybatis/mybatis-config.xml";
	// InputStream inputStream = Resources.getResourceAsStream(resource);
	//
	// SqlSessionFactory sqlSessionFactory = new
	// SqlSessionFactoryBuilder().build(inputStream);
	// MybatisUserRepository repository = new MybatisUserRepository();
	// repository.setSqlSessionFactory(sqlSessionFactory);
	//
	// userApplicationService = new UserApplicationService(repository);
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }

	// @Test
	public void testAddUser() {
		// userApplicationService.add(new CreateUserCommand("abc", "13145",
		// "abc1234567"));
		// userApplicationService.addUser(new CreateUserCommand("abc", "123456",
		// "abc1234567"));
	}

	@Test
	public void testAllUsers() {

		List<User> users = userApplicationService.allUsers();
		for (User user : users) {
			System.out.println(user.getId());
		}
		System.out.println("----------------");
		Pagination<User> pagination = userApplicationService.allUsers(1, 2);
		for (User user : pagination.getResult()) {
			System.out.println(user.getId());
			System.out.println(user.getPhoneNumber());
		}

		System.out.println(pagination.getTotal());

	}

	@Test
	public void testAllUsersIntInt() {

//		userApplicationService.createUser(
//				new CreateUserCommand("0033153", "huangjiu", "123456", "huangjiu", "huangjiu@ane56.com", "", ""));

		List<Role> roles = userRoleRepository.findRolesByUserId(0L);

		for (Role role : roles) {
			System.out.println(role.getName());
		}
	}

}
