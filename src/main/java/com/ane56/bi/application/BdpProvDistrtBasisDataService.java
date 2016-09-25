package com.ane56.bi.application;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ane56.bi.domain.basic.BdpProvDistrtBasicData;
import com.ane56.bi.domain.basic.BdpProvDistrtBasicDataRepository;
import com.ane56.bi.domain.basic.BdpProvDistrtBasicDataVO;
import com.ane56.db.mybatis.core.Pagination;

/**
 * 
 * @author 张一波
 *
 */
@Service
public class BdpProvDistrtBasisDataService {
	@Autowired
	private BdpProvDistrtBasicDataRepository bdpProvDistrtBasicDataRepository;
	/**
	 * 查询所有区域
	 * @return
	 * @throws Exception
	 */
	public List<BdpProvDistrtBasicDataVO> getAreaAll(){
		return bdpProvDistrtBasicDataRepository.getAreaAll();
	}
	/**
	 * 查询所有省区
	 * @return
	 */
	public List<BdpProvDistrtBasicDataVO> getProvinceAll(){
		return bdpProvDistrtBasicDataRepository.getProvinceAll();
	}
	/**
	 * 分页查询省区
	 * @param paramObject
	 * @param offset
	 * @param limit
	 * @return
	 */
	public Pagination<BdpProvDistrtBasicDataVO> getProveWithPage(
			Map<String,Object> paramObject,int offset, int limit){
		return bdpProvDistrtBasicDataRepository.getProveWithPage(paramObject, offset, limit);
	}
	/**
	 * 分页查询大区
	 * @param paramObject
	 * @param offset
	 * @param limit
	 * @return
	 */
	public Pagination<BdpProvDistrtBasicDataVO> getDictrtWithPage(
			Map<String,Object> paramObject,int offset, int limit){
		return bdpProvDistrtBasicDataRepository.getDictrtWithPage(paramObject, offset, limit);
	}
	/**
	 * 查询单条数据
	 * @param entity
	 * @return
	 */
	public BdpProvDistrtBasicData findOne(BdpProvDistrtBasicData entity){
		BdpProvDistrtBasicData provDistrt = bdpProvDistrtBasicDataRepository.findOne(entity);
		return provDistrt;
	}
	/**
	 * 查询单条数据
	 * @param orgBrnchId
	 * @param orgBrnchLvlCd
	 * @param orgBrnchTypeCd
	 * @return
	 */
	public BdpProvDistrtBasicData findOne(String orgBrnchId,String orgBrnchLvlCd,String orgBrnchTypeCd){
		BdpProvDistrtBasicData entity = new BdpProvDistrtBasicData();
		entity.setOrgBrnchId(orgBrnchId);
		entity.setOrgBrnchLvlCd(orgBrnchLvlCd);
		entity.setOrgBrnchTypeCd(orgBrnchTypeCd);
		return this.findOne(entity);
	}
	/**
	 * 更新省区/大区
	 * @param entity
	 * @return
	 */
	public int updateProvDistrt(BdpProvDistrtBasicData entity){
		int result = bdpProvDistrtBasicDataRepository.updateProvDistrt(entity);
		return result;
	}
	/**
	 * (逻辑)删除省区/大区
	 * @param entity
	 * @return
	 */
	public int deleteProvDistrt(BdpProvDistrtBasicData entity){
		entity.setValidFlag("0");
		int result = bdpProvDistrtBasicDataRepository.deleteProvDistrt(entity);
		return result;
	}
	/**
	 * 新增省区/大区
	 * @param entity
	 * @return
	 */
	public int addProvDistrt(BdpProvDistrtBasicData entity){
		int result = bdpProvDistrtBasicDataRepository.addProvDistrt(entity);
		return result;
	}
	
}
