package com.ane56.bi.domain.operation;
import java.util.List;
import java.util.Map;
import com.ane56.db.mybatis.core.Pagination;

public interface TargetCostRepository {

	int add(TargetCost entity);

	int update(TargetCost entity);

	int delete(Map<String,Object> condition);

	Pagination<TargetCost> queryAllData(int start, int limit);

	List<TargetCost> findByParams(Map<String,Object> condition);

}
