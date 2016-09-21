package com.ane56.bi.port.adapter.persistence;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ane56.bi.common.pager.Pagination;
import com.ane56.bi.domain.operation.BdpKpiBasisData;
import com.ane56.bi.domain.operation.KpiBasicDataRepository;
import com.github.pagehelper.PageHelper;

@Component
public class MybatisKpiBasicDataRepository extends SpringMybatisRepositorySupport implements KpiBasicDataRepository {

	@Override
	public int add(BdpKpiBasisData data) {
		int result = this.repository().insert("BdpKpiBasisDataMapper.insert", data);
		return result;
	}

	@Override
	public int update(BdpKpiBasisData data) {
		int result = this.repository().update("BdpKpiBasisDataMapper.update", data);		
		return result;
	}

	@Override
	public int delete(Map<String,Object> condition) {
		int result  = this.repository().delete("BdpKpiBasisDataMapper.delete", condition);
		return result;
	}
	@Override
	public Pagination<BdpKpiBasisData> queryDataByPage(Map<String,Object> searchMap,int pageNum,int pageSize) {
		Pagination<BdpKpiBasisData> pageList =  new Pagination<BdpKpiBasisData>();
		try {
			int offset = (pageNum-1)*pageSize;
			int limit = pageSize;
			Integer total =  (Integer) this.repository().queryBy("BdpKpiBasisDataMapper.queryPagedCount", searchMap);
			PageHelper.startPage(pageNum, pageSize); 	
			List<BdpKpiBasisData> result = this.repository().query("BdpKpiBasisDataMapper.queryPagedList", searchMap);
			pageList.setResult(result);
			pageList.setCurrent(pageNum);
			pageList.setLimit(limit);
			pageList.setOffset(offset);
			pageList.setTotal(total);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageList;
	};
	@Override
	public List<BdpKpiBasisData> findByParams(Map<String,Object> condition) {
		List<BdpKpiBasisData> result = this.repository().query("BdpKpiBasisDataMapper.findByParams", condition);
		return result;
	}

}
