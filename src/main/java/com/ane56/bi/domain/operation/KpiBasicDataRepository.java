package com.ane56.bi.domain.operation;
import java.util.List;
import java.util.Map;

import com.ane56.db.mybatis.core.Pagination;

public interface KpiBasicDataRepository {

	int add(KpiBasicData user);

	int update(KpiBasicData user);

	int delete(KpiBasicData user);

	Pagination<KpiBasicData> queryAllData(int start, int limit);

	List<KpiBasicData> findByParams(Map<String,Object> condition);

}
