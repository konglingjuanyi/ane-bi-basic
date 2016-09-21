package com.ane56.bi.domain.operation;
import java.util.List;
import java.util.Map;

import com.ane56.bi.common.pager.Pagination;
public interface BdpDlyrptMdlRepository {
	int add(BdpDlyrptMdl entity);

	int update(BdpDlyrptMdl entity);

	int delete(Map<String,Object> condition);

	Pagination<BdpDlyrptMdl> queryDataByPage(Map<String,Object> paramObject,int pageNum, int pageSize);

	List<BdpDlyrptMdl> findByParams(Map<String,Object> condition);
}