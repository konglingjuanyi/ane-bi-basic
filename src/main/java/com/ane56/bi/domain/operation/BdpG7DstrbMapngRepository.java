package com.ane56.bi.domain.operation;
import java.util.List;
import java.util.Map;

import com.ane56.bi.common.pager.Pagination;
public interface BdpG7DstrbMapngRepository {
	int add(BdpG7DstrbMapng entity);

	int update(BdpG7DstrbMapng entity);

	int delete(Map<String,Object> condition);

	Pagination<BdpG7DstrbMapng> queryDataByPage(Map<String,Object> paramObject,int pageNum, int pageSize);

	List<BdpG7DstrbMapng> findByParams(Map<String,Object> condition);
}