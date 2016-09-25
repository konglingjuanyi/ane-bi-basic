package com.ane56.bi.domain.basic;

import java.util.Map;

import com.ane56.db.mybatis.core.Pagination;
/**
 * 
 * @author 张一波
 *
 */
public interface OrgBrnchClfcRepository {
	/**
	 * 查询分拨属性
	 * @param paramObject
	 * @param offset
	 * @param limit
	 * @return
	 */
	public Pagination<OrgBrnchClfcVO> getOrgBrnchClfc(Map<String,Object> paramObject,int offset, int limit);
	/**
	 * 更新
	 * @param entity
	 * @return
	 */
	public int update(OrgBrnchClfc entity);
}
