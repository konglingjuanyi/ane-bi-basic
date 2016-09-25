package com.ane56.bi.port.adapter.persistence;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ane56.bi.common.pager.Pagination;
import com.ane56.bi.domain.operation.BdpTgtVal;
import com.ane56.bi.domain.operation.BdpTgtValRepository;
import com.github.pagehelper.PageHelper;

@Component
public class MybatisBdpTgtValRepository extends SpringMybatisRepositorySupport implements BdpTgtValRepository {

	@Override
	public int add(BdpTgtVal data) {
		int result = this.repository().insert("BdpTgtValMapper.insert", data);
		return result;
	}

	@Override
	public int update(BdpTgtVal data) {
		int result = this.repository().update("BdpTgtValMapper.update", data);		
		return result;
	}

	@Override
	public int delete(Map<String,Object> condition) {
		int result  = this.repository().delete("BdpTgtValMapper.delete", condition);
		return result;
	}
	@Override
	public Pagination<BdpTgtVal> queryDataByPage(Map<String,Object> searchMap,int pageNum,int pageSize) {
		Pagination<BdpTgtVal> pageList =  new Pagination<BdpTgtVal>();
		try {
			int offset = (pageNum-1)*pageSize;
			int limit = pageSize;
			Integer total =  (Integer) this.repository().queryBy("BdpTgtValMapper.queryPagedCount", searchMap);
			PageHelper.startPage(pageNum, pageSize); 	
			List<BdpTgtVal> result = this.repository().query("BdpTgtValMapper.queryPagedList", searchMap);
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
	public List<BdpTgtVal> findByParams(Map<String,Object> condition) {
		List<BdpTgtVal> result = this.repository().query("BdpTgtValMapper.findByParams", condition);
		return result;
	}

}
