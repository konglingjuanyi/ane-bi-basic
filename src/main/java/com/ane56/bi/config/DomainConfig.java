package com.ane56.bi.config;

import com.ane56.bi.domain.user.EncryptionService;
import com.ane56.bi.domain.user.RoleService;
import com.ane56.bi.domain.user.UserService;
import com.ane56.bi.port.adapter.service.Md5EncryptionService;

@Configuration
@ComponentScan(basePackages = { "com.ane56.bi.port.adapter.persistence" })
public class DomainConfig {

	@Bean
	public MybatisRepositorySupport mybatisRepositorySupport(SqlSessionFactory sqlSessionFactory) {
		return new MybatisRepositorySupport(sqlSessionFactory);
	}

	@Bean
	public UserService userService() {
		return new UserService();
	}

	@Bean
	public RoleService roleService() {
		return new RoleService();
	}

	@Bean
	public EncryptionService encryptionService() {
		return new Md5EncryptionService();
	}

}
