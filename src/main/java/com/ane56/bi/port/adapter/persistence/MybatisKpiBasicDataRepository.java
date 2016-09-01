package com.ane56.bi.port.adapter.persistence;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ane56.bi.common.pager.PageBean;
import com.ane56.bi.common.pager.PageConstants;
import com.ane56.bi.domain.operation.KpiBasicData;
import com.ane56.bi.domain.operation.KpiBasicDataRepository;
import com.ane56.db.mybatis.core.Pagination;
import com.ane56.db.mybatis.query.QueryBuilder;
import com.ane56.db.mybatis.query.SqlQuery;

@Component
public class MybatisKpiBasicDataRepository extends SpringMybatisRepositorySupport implements KpiBasicDataRepository {

	@Override
	public int add(KpiBasicData data) {
		int result = this.repository().insert("Opt_KpiBasicDataDao.add", data);
		return result;
	}

	@Override
	public int update(KpiBasicData data) {
		int result = this.repository().update("Opt_KpiBasicDataDao.update", data);		
		return result;
	}

	@Override
	public int delete(KpiBasicData data) {
		int result  = this.repository().delete("Opt_KpiBasicDataDao.delete", data);
		return result;
	}

	/*@Override
	public PageBean<KpiBasicData> queryDataByPage(Map<String,Object> paramObject,int offset, int limit) {
		//每页记录数
		Integer total =  (Integer) this.repository().queryBy("Opt_KpiBasicDataDao.queryPageCount", paramObject);
		Pagination<KpiBasicData> pageResult= this.repository().queryPage("Opt_KpiBasicDataDao.queryDataByPage", paramObject, offset, limit);
		List<KpiBasicData> dataList = pageResult.getResult();
		
		 * 5. 创建PageBean，设置参数
		 
		PageBean<KpiBasicData> pb = new PageBean<KpiBasicData>();
		
		 * 其中PageBean没有url，这个任务由Servlet完成
		 
		pb.setBeanList(dataList);
		pb.setTotal(total);
		return pb;
	}*/
	@Override
	public PageBean<KpiBasicData> queryDataByPage(Map<String,Object> searchMap,int offset, int limit) {
		 PageBean<KpiBasicData> pageList = null;
		try {
			pageList = this.queryPagedList("Opt_KpiBasicDataDao", KpiBasicData.class, searchMap, offset, limit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageList;
	}
	@Override
	public List<KpiBasicData> findByParams(Map<String,Object> condition) {
		List<KpiBasicData> result = this.repository().query("Opt_KpiBasicDataDao.findByParams", condition);
		return result;
	}

}
