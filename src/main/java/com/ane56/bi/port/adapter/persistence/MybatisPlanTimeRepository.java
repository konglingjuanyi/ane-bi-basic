package com.ane56.bi.port.adapter.persistence;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.ane56.bi.common.pager.PageBean;
import com.ane56.bi.common.pager.Pagination;
import com.ane56.bi.domain.operation.BdpDlyrptMdl;
import com.ane56.bi.domain.operation.BdpDstrbPlanOpTime;
import com.ane56.bi.domain.operation.PlanTimeRepository;
import com.github.pagehelper.PageHelper;

@Component
public class MybatisPlanTimeRepository extends SpringMybatisRepositorySupport implements PlanTimeRepository {

	@Override
	public int add(BdpDstrbPlanOpTime data) {
		int result = this.repository().insert("BdpDstrbPlanOpTimeMapper.insert", data);
		return result;
	}

	@Override
	public int update(BdpDstrbPlanOpTime data) {
		int result = this.repository().update("BdpDstrbPlanOpTimeMapper.update", data);		
		return result;
	}

	@Override
	public int delete(Map<String,Object> condition) {
		int result  = this.repository().delete("BdpDstrbPlanOpTimeMapper.delete", condition);
		return result;
	}

	@Override
	public Pagination<BdpDstrbPlanOpTime> queryDataByPage(Map<String,Object> searchMap,int pageNum,int pageSize) {
		Pagination<BdpDstrbPlanOpTime> pageList =  new Pagination<BdpDstrbPlanOpTime>();
		try {
			int offset = (pageNum-1)*pageSize;
			int limit = pageSize;
			Integer total =  (Integer) this.repository().queryBy("BdpDstrbPlanOpTimeMapper.queryPagedCount", searchMap);
			PageHelper.startPage(pageNum, pageSize); 	
			List<BdpDstrbPlanOpTime> result = this.repository().query("BdpDstrbPlanOpTimeMapper.queryPagedList", searchMap);
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
	public List<BdpDstrbPlanOpTime> findByParams(Map<String,Object> condition) {
		List<BdpDstrbPlanOpTime> result = this.repository().query("BdpDstrbPlanOpTimeMapper.findByParams", condition);
		return result;
	}

}
