package com.ane56.bi.domain.operation;
import java.util.List;
import java.util.Map;

import com.ane56.bi.common.pager.Pagination;
public interface BdpTgtValRepository {
	int add(BdpTgtVal entity);

	int update(BdpTgtVal entity);

	int delete(Map<String,Object> condition);

	Pagination<BdpTgtVal> queryDataByPage(Map<String,Object> paramObject,int pageNum, int pageSize);

	List<BdpTgtVal> findByParams(Map<String,Object> condition);
}