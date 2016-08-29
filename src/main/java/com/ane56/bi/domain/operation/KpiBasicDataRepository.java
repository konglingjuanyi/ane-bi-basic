package com.ane56.bi.domain.operation;
import java.util.List;
import java.util.Map;

import com.ane56.db.mybatis.core.Pagination;

public interface KpiBasicDataRepository {

	int add(KpiBasicData entity);

	int update(KpiBasicData entity);

	int delete(KpiBasicData entity);

	Pagination<KpiBasicData> queryAllData(int start, int limit);

	List<KpiBasicData> findByParams(Map<String,Object> condition);

}
