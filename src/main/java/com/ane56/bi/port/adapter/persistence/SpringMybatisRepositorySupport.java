package com.ane56.bi.port.adapter.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ane56.bi.common.pager.PageBean;
import com.ane56.bi.port.adapter.utils.PageUtils;
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
		//Pagination<Object> result = null;
		Integer total =  (Integer) this.repository().queryBy(nameSpace+".queryPagedCount", searchMap);
		pb.setTotal(total);
		if(total==0){
			return pb;
		}else{
			 searchMap.put("offset", offset);
			 searchMap.put("limit", limit);
			 List<T>  result = this.repository().query(nameSpace+".queryPagedList", searchMap);
			  pb.setBeanList(result);
		}
		return pb;
	  }
	/**
	 * 分页查询
	 * @param nameSpace
	 * @param searchMap
	 * @param offset
	 * @param limit
	 * @return
	 */
	public <T> Pagination<T> queryWithPage(String nameSpace,Map<String,Object> searchMap, int offset, int limit){
		Integer total =  (Integer) this.repository().queryBy(nameSpace+".queryPagedCount", searchMap);
		searchMap.put("start", offset);
		searchMap.put("end", PageUtils.getEnd(offset, limit));
		List<T> result = this.repository().query(nameSpace+".queryPagedList", searchMap);
		return new Pagination<T>(result, total, offset, limit);
	}
}
