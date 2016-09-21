package com.ane56.bi.port.adapter.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ane56.bi.domain.resource.RoleRource;
import com.ane56.bi.domain.resource.RoleRourceRepository;
import com.ane56.db.mybatis.MybatisRepositorySupport;
import com.ane56.db.mybatis.query.QueryBuilder;

/**
 * 类描述:用户角色关联实现类
 * @author hanyong
 */
@Component
public class MybatisRoleSourceRepository extends MybatisRepositorySupport implements RoleRourceRepository {

	@Autowired
	public MybatisRoleSourceRepository(SqlSessionFactory sqlSessionFactory) {
		super(sqlSessionFactory);
	}

	/**
	 * 查询角色的所有权限
	 * @param QueryBuilder:查询条件
	 * @author hanyong
	 */
	@Override
	public List<RoleRource> allRoleSources(QueryBuilder qb) {
		return query(qb.build());
	}

	/**
	 * 为角色分配权限
	 * @param useRrole:角色权限关联类
	 * @author hanyong
	 */
	@Override
	public void add(RoleRource roleSource) {
		insert(roleSource);
	}

	/**
	 * 删除角色权限
	 * @param useRrole:角色权限关联类
	 * @author hanyong
	 */
	@Override
	public void remove(RoleRource roleSource) {
		delete(roleSource);
	}
}
