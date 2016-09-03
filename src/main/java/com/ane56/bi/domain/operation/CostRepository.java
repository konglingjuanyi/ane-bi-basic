package com.ane56.bi.domain.operation;
import java.util.List;
import java.util.Map;
import com.ane56.db.mybatis.core.Pagination;

public interface CostRepository {

	int add(Cost entity);

	int update(Cost entity);

	int delete(Map<String,Object> condition);

	Pagination<Cost> queryAllData(int start, int limit);

	List<Cost> findByParams(Map<String,Object> condition);

}
