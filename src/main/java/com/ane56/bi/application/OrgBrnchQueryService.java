package com.ane56.bi.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ane56.bi.domain.basic.OrgBrnchQueryRepository;
import com.ane56.bi.domain.basic.OrgBrnchQueryVO;
/**
 * 各层级组织机构service
 * @author 张一波
 *
 */
@Service
public class OrgBrnchQueryService {
	@Autowired
	private OrgBrnchQueryRepository orgBrnchQueryRepository;
	
	/**
	 * 获取所有分拨
	 * @return
	 */
	public List<OrgBrnchQueryVO> getSiteAll(){
		return orgBrnchQueryRepository.getSiteAll();
	}
	/**
	 * 获取所有运营大区
	 * @return
	 */
	public List<OrgBrnchQueryVO> getDistrtAll(){
		return orgBrnchQueryRepository.getDistrtAll();
	}
	/**
	 * 获取所有运营省区
	 * @return
	 */
	public List<OrgBrnchQueryVO> getProvAll(){
		return orgBrnchQueryRepository.getProvAll();
	}
	/**
	 * 获取所有区域
	 * @return
	 */
	public List<OrgBrnchQueryVO> getAreaAll(){
		return orgBrnchQueryRepository.getAreaAll();
	}

}
