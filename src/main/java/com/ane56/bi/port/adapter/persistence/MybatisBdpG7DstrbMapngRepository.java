package com.ane56.bi.port.adapter.persistence;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ane56.bi.common.pager.Pagination;
import com.ane56.bi.domain.operation.BdpG7DstrbMapng;
import com.ane56.bi.domain.operation.BdpG7DstrbMapngRepository;
import com.github.pagehelper.PageHelper;

@Component
public class MybatisBdpG7DstrbMapngRepository extends SpringMybatisRepositorySupport implements BdpG7DstrbMapngRepository {

	@Override
	public int add(BdpG7DstrbMapng data) {
		int result = this.repository().insert("BdpG7DstrbMapngMapper.insert", data);
		return result;
	}

	@Override
	public int update(BdpG7DstrbMapng data) {
		int result = this.repository().update("BdpG7DstrbMapngMapper.update", data);		
		return result;
	}

	@Override
	public int delete(Map<String,Object> condition) {
		int result  = this.repository().delete("BdpG7DstrbMapngMapper.delete", condition);
		return result;
	}
	@Override
	public Pagination<BdpG7DstrbMapng> queryDataByPage(Map<String,Object> searchMap,int pageNum,int pageSize) {
		Pagination<BdpG7DstrbMapng> pageList =  new Pagination<BdpG7DstrbMapng>();
		try {
			int offset = (pageNum-1)*pageSize;
			int limit = pageSize;
			Integer total =  (Integer) this.repository().queryBy("BdpG7DstrbMapngMapper.queryPagedCount", searchMap);
			PageHelper.startPage(pageNum, pageSize); 	
			List<BdpG7DstrbMapng> result = this.repository().query("BdpG7DstrbMapngMapper.queryPagedList", searchMap);
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
	public List<BdpG7DstrbMapng> findByParams(Map<String,Object> condition) {
		List<BdpG7DstrbMapng> result = this.repository().query("BdpG7DstrbMapngMapper.findByParams", condition);
		return result;
	}

}
