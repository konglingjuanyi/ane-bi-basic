package com.ane56.bi.port.adapter.persistence;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ane56.bi.domain.basic.OrgBrnchQueryVO;
import com.ane56.bi.domain.basic.OrgBrnchQueryRepository;
/**
 * 获取各层级组织机构
 * @author 张一波
 *
 */
@Component
public class MybatisOrgBrnchQueryRepository extends SpringMybatisRepositorySupport implements OrgBrnchQueryRepository{

	/**
	 * 查询分拨list
	 */
	public List<OrgBrnchQueryVO> getSiteAll() {
		List<OrgBrnchQueryVO> pageData = this.repository().query("Bdp_OrgBrnchQuery.querySiteList");
		return pageData;
	}
	/**
	 * 查询运营大区list
	 */
	public List<OrgBrnchQueryVO> getDistrtAll() {
		List<OrgBrnchQueryVO> pageData = this.repository().query("Bdp_OrgBrnchQuery.queryDistrtList");
		return pageData;
	}
	/**
	 * 查询运营省区list
	 */
	public List<OrgBrnchQueryVO> getProvAll() {
		List<OrgBrnchQueryVO> pageData = this.repository().query("Bdp_OrgBrnchQuery.queryProvList");
		return pageData;
	}
	/**
	 * 查询区域list
	 */
	public List<OrgBrnchQueryVO> getAreaAll() {
		List<OrgBrnchQueryVO> pageData = this.repository().query("Bdp_OrgBrnchQuery.queryAreaList");
		return pageData;
	}

}
