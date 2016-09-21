package com.ane56.bi.domain.operation;
import java.util.List;
import java.util.Map;

import com.ane56.bi.common.pager.PageBean;

public interface FixedTargetRepository {

	int add(BdpTgtVal entity);

	int update(BdpTgtVal entity);

	int delete(BdpTgtVal entity);

	PageBean<BdpTgtVal> queryDataByPage(Map<String,Object> paramObject,int offset, int limit);

	List<BdpTgtVal> findByParams(Map<String,Object> condition);

}
