package com.ane56.bi.domain.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ane56.db.mybatis.spring.Mapper;

/**
 * 类描述:用户角色关联接口类
 * 
 * @author hanyong
 */
@Mapper
public interface UserRoleRepository {

	List<User> findUsersByRoleId(long roleId);

	List<Role> findRolesByUserId(long userId);

	void insert(UserRole useRrole);

	void removeBy(long userId, long roleId);

	List<UserRole> findBy(@Param("userId") long userId, @Param("roleId") long roleId);
}
