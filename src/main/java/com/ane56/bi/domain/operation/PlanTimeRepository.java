package com.ane56.bi.domain.operation;
import java.util.List;
import java.util.Map;
import com.ane56.bi.common.pager.PageBean;

public interface PlanTimeRepository {

	int add(BdpDstrbPlanOpTime entity);

	int update(BdpDstrbPlanOpTime entity);

	int delete(Map<String, Object> condition);

	PageBean<BdpDstrbPlanOpTime> queryDataByPage(Map<String,Object> paramObject,int offset, int limit);

	List<BdpDstrbPlanOpTime> findByParams(Map<String,Object> condition);

}
