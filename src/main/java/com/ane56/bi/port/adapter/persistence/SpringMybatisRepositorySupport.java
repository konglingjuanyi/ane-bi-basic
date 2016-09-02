package com.ane56.bi.port.adapter.persistence;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.ane56.bi.common.pager.PageBean;
import com.ane56.db.mybatis.MybatisRepository;
import com.ane56.db.mybatis.MybatisRepositorySupport;
import com.ane56.db.mybatis.core.Pagination;
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
	public <T> PageBean<T> queryPagedList(String nameSpace,Class<T> clz, Map<String,Object> searchMap, int offset, int limit) throws Exception
	  {
		/*
		 * 5. 创建PageBean，设置参数
		 */
	    PageBean<T> pb = new PageBean<T>();
		Integer total =  (Integer) this.repository().queryBy(nameSpace+".queryPagedCount", searchMap);
		Pagination<Object> result= this.repository().queryPage(nameSpace+".queryPagedList", searchMap, offset, limit);	
		@SuppressWarnings("unchecked")
		List<T> list = (List<T>) result.getResult();
		pb.setBeanList(list);
		pb.setTotal(total);
		return pb;
	    
	  }
}
