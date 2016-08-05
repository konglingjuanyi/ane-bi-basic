package com.ane56.bi.domain.resource;

import java.util.List;

import com.ane56.db.mybatis.query.QueryBuilder;

/**
 * 类描述:角色权限关联接口类
 * @author hanyong
 */
public interface RoleRourceRepository {

	/**
	 * 查询角色的所有权限
	 * @param QueryBuilder:查询条件
	 * @author hanyong
	 */
	List<RoleRource> allRoleSources(QueryBuilder qb);
	
	/**
	 * 为角色分配权限
	 * @param useRrole:角色权限关联类
	 * @author hanyong
	 */
	void add(RoleRource roleSource);
	
	/**
	 * 删除角色权限
	 * @param useRrole:角色权限关联类
	 * @author hanyong
	 */
	void remove(RoleRource roleSource);
}
