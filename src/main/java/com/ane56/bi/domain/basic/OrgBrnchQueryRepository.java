package com.ane56.bi.domain.basic;

import java.util.List;
/**
 * 获取各层级组织机构
 * @author 张一波
 *
 */
public interface OrgBrnchQueryRepository {
	/**
	 * 获取所有分拨
	 * @return
	 */
	public List<OrgBrnchQueryVO> getSiteAll();
	/**
	 * 获取所有运营大区
	 * @return
	 */
	public List<OrgBrnchQueryVO> getDistrtAll();
	/**
	 * 获取所有运营省区
	 * @return
	 */
	public List<OrgBrnchQueryVO> getProvAll();
	/**
	 * 获取所有区域
	 * @return
	 */
	public List<OrgBrnchQueryVO> getAreaAll();
}
