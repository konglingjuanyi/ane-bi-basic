package com.ane56.bi.domain.operation;
import java.util.List;
import java.util.Map;

public interface DailyModuleRepository {

	int add(DailyModule entity);

	int update(DailyModule entity);

	int delete(Map<String,Object> condition);

	Pagination<DailyModule> queryAllData(int start, int limit);

	List<DailyModule> findByParams(Map<String,Object> condition);

}
