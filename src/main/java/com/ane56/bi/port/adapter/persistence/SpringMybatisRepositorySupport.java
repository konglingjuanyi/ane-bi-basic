package com.ane56.bi.port.adapter.persistence;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ane56.db.mybatis.MybatisRepository;
import com.ane56.db.mybatis.MybatisRepositorySupport;
import com.ane56.db.mybatis.query.QueryBuilder;

public class SpringMybatisRepositorySupport {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	private MybatisRepository mybatisRepository;

	protected MybatisRepository repository() {
		if (this.mybatisRepository == null) {
			this.mybatisRepository = new MybatisRepositorySupport(sqlSessionFactory);
		}
		return this.mybatisRepository;
	}

	protected <T> T findByProp(Class<T> entity, String name, String value) {
		T result = this.repository().queryBy(new QueryBuilder(entity).eq(name, value).build());
		return result;
	}

}
