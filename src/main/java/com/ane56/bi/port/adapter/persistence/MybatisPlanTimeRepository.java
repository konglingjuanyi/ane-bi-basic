package com.ane56.bi.port.adapter.persistence;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ane56.bi.common.pager.PageBean;
import com.ane56.bi.common.pager.PageConstants;
import com.ane56.bi.domain.operation.PlanTime;
import com.ane56.bi.domain.operation.PlanTimeRepository;
import com.ane56.db.mybatis.core.Pagination;
import com.ane56.db.mybatis.query.QueryBuilder;
import com.ane56.db.mybatis.query.SqlQuery;

@Component
public class MybatisPlanTimeRepository extends SpringMybatisRepositorySupport implements PlanTimeRepository {

	@Override
	public int add(PlanTime data) {
		int result = this.repository().insert("Opt_PlanTimeDao.add", data);
		return result;
	}

	@Override
	public int update(PlanTime data) {
		int result = this.repository().update("Opt_PlanTimeDao.update", data);		
		return result;
	}

	@Override
	public int delete(PlanTime data) {
		int result  = this.repository().delete("Opt_PlanTimeDao.delete", data);
		return result;
	}

	/*@Override
	public PageBean<PlanTime> queryDataByPage(Map<String,Object> paramObject,int offset, int limit) {
		//每页记录数
		Integer total =  (Integer) this.repository().queryBy("Opt_PlanTimeDao.queryPageCount", paramObject);
		Pagination<PlanTime> pageResult= this.repository().queryPage("Opt_PlanTimeDao.queryDataByPage", paramObject, offset, limit);
		List<PlanTime> dataList = pageResult.getResult();
		
		 * 5. 创建PageBean，设置参数
		 
		PageBean<PlanTime> pb = new PageBean<PlanTime>();
		
		 * 其中PageBean没有url，这个任务由Servlet完成
		 
		pb.setBeanList(dataList);
		pb.setTotal(total);
		return pb;
	}*/
	@Override
	public PageBean<PlanTime> queryDataByPage(Map<String,Object> searchMap,int offset, int limit) {
		 PageBean<PlanTime> pageList = null;
		try {
			pageList = this.queryPagedList("Opt_PlanTimeDao", PlanTime.class, searchMap, offset, limit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageList;
	}
	@Override
	public List<PlanTime> findByParams(Map<String,Object> condition) {
		List<PlanTime> result = this.repository().query("Opt_PlanTimeDao.findByParams", condition);
		return result;
	}

}
