package com.ane56.bi.domain.operation;
import java.util.List;
import java.util.Map;

import com.ane56.db.mybatis.core.Pagination;

public interface DimensionKpiRepository {

	int add(DimensionKpi entity);

	int update(DimensionKpi entity);

	int delete(Map<String,Object> condition);

	Pagination<DimensionKpi> queryAllData(int start, int limit);

	List<DimensionKpi> findByParams(Map<String,Object> condition);
	
	public List<Map<String, Object>> exportEntities(Map<String,Object> condition);
}
