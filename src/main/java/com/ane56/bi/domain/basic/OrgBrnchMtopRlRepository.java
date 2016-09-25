package com.ane56.bi.domain.basic;

import java.util.List;
import java.util.Map;

import com.ane56.db.mybatis.core.Pagination;

/**
 * 组织架构
 * @author 张一波
 *
 */
public interface OrgBrnchMtopRlRepository {
	/**
	 * 分页查询组织机构关系
	 * @param searchMap
	 * @param offset
	 * @param limit
	 * @return
	 */
	public Pagination<OrgBrnchQueryVO> getMtopRlWithPage(Map<String, Object> searchMap, int offset, int limit);
	/**
	 * 更新组织架构关系
	 * @param entity
	 * @return
	 */
	public int updateOrgBrnchMtopRl(OrgBrnchMtopRl entity);
	/**
	 * 信息组织架构关系
	 * @param entity
	 * @return
	 */
	public int addOrgBrnchMtopRl(OrgBrnchMtopRl entity);
	/**
	 * 获取一条数据
	 * @param entity
	 * @return
	 */
	public OrgBrnchMtopRl findOne(OrgBrnchMtopRl entity);
	
}
