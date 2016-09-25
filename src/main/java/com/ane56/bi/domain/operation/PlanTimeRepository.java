package com.ane56.bi.domain.operation;
import java.util.List;
import java.util.Map;
import com.ane56.bi.common.pager.PageBean;
import com.ane56.bi.common.pager.Pagination;

public interface PlanTimeRepository {

	int add(BdpDstrbPlanOpTime entity);

	int update(BdpDstrbPlanOpTime entity);

	int delete(Map<String, Object> condition);
	Pagination<BdpDstrbPlanOpTime> queryDataByPage(Map<String,Object> paramObject,int pageNum, int pageSize);
	List<BdpDstrbPlanOpTime> findByParams(Map<String,Object> condition);

}
