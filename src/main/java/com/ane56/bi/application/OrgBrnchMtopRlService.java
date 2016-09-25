package com.ane56.bi.application;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ane56.bi.domain.basic.BdpProvDistrtBasicData;
import com.ane56.bi.domain.basic.OrgBrnchMtopRl;
import com.ane56.bi.domain.basic.OrgBrnchMtopRlRepository;
import com.ane56.bi.domain.basic.OrgBrnchQueryVO;
import com.ane56.bi.port.adapter.utils.Constants;
import com.ane56.db.mybatis.core.Pagination;
/**
 * 组织架构
 * @author 张一波
 *
 */
@Service
public class OrgBrnchMtopRlService {
	@Autowired
	private OrgBrnchMtopRlRepository orgBrnchMtopRlRepository;
	@Autowired
	private OrgBrnchQueryService orgBrnchQueryService;
	@Autowired
	private BdpProvDistrtBasisDataService bdpProvDistrtBasisDataService;
	/**
	 * 分页查询组织机构关系
	 * @param searchMap
	 * @param offset
	 * @param limit
	 * @return
	 */
	public Pagination<OrgBrnchQueryVO> getMtopRlWithPage(Map<String, Object> searchMap, int offset, int limit){
		return orgBrnchMtopRlRepository.getMtopRlWithPage(searchMap, offset, limit);
	}
	/**
	 * 获取所有分拨
	 * @return
	 */
	public List<OrgBrnchQueryVO> getSiteAll(){
		return orgBrnchQueryService.getSiteAll();
	}
	/**
	 * 获取所有运营大区
	 * @return
	 */
	public List<OrgBrnchQueryVO> getDistrtAll(){
		return orgBrnchQueryService.getDistrtAll();
	}
	/**
	 * 获取所有运营省区
	 * @return
	 */
	public List<OrgBrnchQueryVO> getProvAll(){
		return orgBrnchQueryService.getProvAll();
	}
	/**
	 * 获取所有区域
	 * @return
	 */
	public List<OrgBrnchQueryVO> getAreaAll(){
		return orgBrnchQueryService.getAreaAll();
	}
	/**
	 * 保存组织架构关系处理
	 * @param oriData
	 * @param upData
	 * @return
	 */
	public int saveOrgBrnchMtopRl(OrgBrnchQueryVO oriData,OrgBrnchQueryVO upData) {
		int result = 1;
		int result1 = 0;
		boolean isSiteToDict = false;// 判断是否更新分拨-大区
		if(!oriData.getDictId().equals(upData.getDictId())){// 如果大区变更
			result1 = this.updateOrgBrnchMtopRl(oriData.getSiteId(),"12",upData.getDictId());// 更新：分拨-大区
			isSiteToDict = true;
		}
		if(isSiteToDict && result1<1){// 更新失败
			result = 0;
		}else{
			//操作大区-省区
			int result2 = 0;
			boolean isDictToProvince = false;// 判断是否更新或新增大区-省区
			OrgBrnchMtopRl orgDictToProvince = this.finfOne(upData.getDictId(), "23", "");// 根据大区id,查询大区-省区
			if(orgDictToProvince==null){// 该大区数据不存在,add
				result2 = this.addOrgBrnchMtopRl(upData.getDictId(), "23", upData.getProvinceId(), "22");
				isDictToProvince = true;
			}else if(!orgDictToProvince.getSuprMtopId().equals(upData.getProvinceId())){// 存在且省区不一致,update
				result2 = this.updateOrgBrnchMtopRl(upData.getDictId(), "23", upData.getProvinceId());// 更新：大区-省区
				isDictToProvince = true;
			}
			if(isDictToProvince && result2<1){//大区-省区操作失败
				if(!oriData.getDictId().equals(upData.getDictId())){// 如果大区变更
					this.updateOrgBrnchMtopRl(upData.getSiteId(),"12",oriData.getDictId());
				}
				result = 0;
			}else{
				//操作省区-区域
				int result3 = 0;
				boolean isProvinceToArea = false;// 判断是否更新或新增省区-区域
				OrgBrnchMtopRl orgProvinceToArea = this.finfOne(upData.getProvinceId(),"22","");// 根据省区id,查询省区-区域
				if(orgProvinceToArea==null){// 该省区数据不存在,add
					result3 = this.addOrgBrnchMtopRl(upData.getProvinceId(), "22", upData.getAreaId(), "21");
					isProvinceToArea = true;
				}else if(!orgProvinceToArea.getSuprMtopId().equals(upData.getAreaId())){// 存在且区域不一致,update
					result3 = this.updateOrgBrnchMtopRl(upData.getProvinceId(), "22", upData.getAreaId());
					isProvinceToArea = true;
				}
				if(isProvinceToArea && result3<1){// 省区-区域操作失败
					if(orgDictToProvince!=null && !orgDictToProvince.getSuprMtopId().equals(upData.getProvinceId())){
						this.updateOrgBrnchMtopRl(upData.getDictId(), "23", oriData.getProvinceId());
					}
					if(!oriData.getDictId().equals(upData.getDictId())){// 如果大区变更
						this.updateOrgBrnchMtopRl(upData.getSiteId(),"12",oriData.getDictId());
					}
					result = 0;
				}
			}
		}
		return result;
	}
	/**
	 * 更新组织架构关系
	 * @param orgBrnchId
	 * @param orgBrnchLvlCd
	 * @param suprMtopId
	 * @return
	 */
	public int updateOrgBrnchMtopRl(String orgBrnchId,String orgBrnchLvlCd,String suprMtopId){
		OrgBrnchMtopRl entity = new OrgBrnchMtopRl();
		entity.setOrgBrnchId(orgBrnchId);
		entity.setOrgBrnchLvlCd(orgBrnchLvlCd);
		entity.setSuprMtopId(suprMtopId);
		if(orgBrnchLvlCd.equals(Constants.ORG_BRNCH_LVL_PROVINCE_AREA)||orgBrnchLvlCd.equals(Constants.ORG_BRNCH_LVL_DICT)){
			BdpProvDistrtBasicData provDistrt = bdpProvDistrtBasisDataService.findOne(orgBrnchId, orgBrnchLvlCd, "");
			entity.setOrgBrnchNm(provDistrt.getOrgBrnchNm());
		}
		return orgBrnchMtopRlRepository.updateOrgBrnchMtopRl(entity);
	}
	/**
	 * 新增组织结构关系
	 * @param orgBrnchId
	 * @param orgBrnchLvlCd
	 * @param suprMtopId
	 * @param suprMtopLvlCd
	 * @return
	 */
	public int addOrgBrnchMtopRl(String orgBrnchId,String orgBrnchLvlCd,String suprMtopId,String suprMtopLvlCd){
		OrgBrnchMtopRl entity = new OrgBrnchMtopRl();
		entity.setOrgBrnchId(orgBrnchId);
		entity.setOrgBrnchLvlCd(orgBrnchLvlCd);
		entity.setSuprMtopId(suprMtopId);
		entity.setSuprMtopLvlCd(suprMtopLvlCd);
		entity.setCrtUserId("0");
		entity.setCrtTime(new Date());
		entity.setCrtAppSysId("BDP");
		BdpProvDistrtBasicData provDistrt = bdpProvDistrtBasisDataService.findOne(orgBrnchId, orgBrnchLvlCd, "");
		entity.setOrgBrnchNm(provDistrt.getOrgBrnchNm());
		return orgBrnchMtopRlRepository.addOrgBrnchMtopRl(entity);
	}
	/**
	 * 查找组织机构关系
	 * @param orgBrnchId
	 * @param orgBrnchLvlCd
	 * @param suprMtopId
	 * @return
	 */
	public OrgBrnchMtopRl finfOne(String orgBrnchId,String orgBrnchLvlCd,String suprMtopId){
		OrgBrnchMtopRl entity = new OrgBrnchMtopRl();
		entity.setOrgBrnchId(orgBrnchId);
		entity.setOrgBrnchLvlCd(orgBrnchLvlCd);
		entity.setSuprMtopId(suprMtopId);
		return orgBrnchMtopRlRepository.findOne(entity);
	}

}
