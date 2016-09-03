package com.ane56.bi.domain.operation;
import java.util.List;
import java.util.Map;
import com.ane56.bi.common.pager.PageBean;

public interface PlanTimeRepository {

	int add(PlanTime entity);

	int update(PlanTime entity);

	int delete(PlanTime entity);

	PageBean<PlanTime> queryDataByPage(Map<String,Object> paramObject,int offset, int limit);

	List<PlanTime> findByParams(Map<String,Object> condition);

}
