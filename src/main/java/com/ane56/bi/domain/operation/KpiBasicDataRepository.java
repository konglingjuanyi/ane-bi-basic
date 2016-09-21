package com.ane56.bi.domain.operation;
import java.util.List;
import java.util.Map;

import com.ane56.bi.common.pager.Pagination;

public interface KpiBasicDataRepository {

	int add(BdpKpiBasisData entity);

	int update(BdpKpiBasisData entity);

	int delete(Map<String,Object> condition);

	Pagination<BdpKpiBasisData> queryDataByPage(Map<String,Object> paramObject,int pageNum, int pageSize);

	List<BdpKpiBasisData> findByParams(Map<String,Object> condition);

}
