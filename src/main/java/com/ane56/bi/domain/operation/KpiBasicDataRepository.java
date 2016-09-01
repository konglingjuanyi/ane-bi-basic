package com.ane56.bi.domain.operation;
import java.util.List;
import java.util.Map;

import com.ane56.bi.common.pager.PageBean;

public interface KpiBasicDataRepository {

	int add(KpiBasicData entity);

	int update(KpiBasicData entity);

	int delete(KpiBasicData entity);

	PageBean<KpiBasicData> queryDataByPage(Map<String,Object> paramObject,int offset, int limit);

	List<KpiBasicData> findByParams(Map<String,Object> condition);

}
