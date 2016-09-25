package com.ane56.bi.port.adapter.web.resource.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ane56.bi.application.BdpProvDistrtBasisDataService;
import com.ane56.bi.domain.basic.BdpProvDistrtBasicData;
import com.ane56.bi.domain.basic.BdpProvDistrtBasicDataVO;
import com.ane56.bi.port.adapter.rest.ResourceResponseSupport;
import com.ane56.bi.port.adapter.rest.RestResultResponse;
import com.ane56.bi.port.adapter.utils.Constants;
import com.ane56.bi.port.adapter.utils.DecodeUtils;
import com.ane56.bi.port.adapter.utils.PageUtils;
import com.ane56.db.mybatis.core.Pagination;
/**
 * 省区大区控制层
 * @author 张一波
 *
 */
@RestController
public class BdpProvDistrtController extends ResourceResponseSupport{
	@Autowired
	private BdpProvDistrtBasisDataService bdpProvDistrtBasisDataService;
	
	/**
	 * 获取所有区域
	 * @return
	 */
	@RequestMapping(value="/api/provDistrt/getAreaAll",method=RequestMethod.GET)
	public RestResultResponse getAreaList(){
		List<BdpProvDistrtBasicDataVO> list = bdpProvDistrtBasisDataService.getAreaAll();
		for(BdpProvDistrtBasicDataVO vo : list){
			vo.setNameWithCode(vo.getOrgBrnchNm()+" "+vo.getOrgBrnchId());
		}
		return this.buildSuccessRestResultResponse(list);
	}
	/**
	 * 获取所有省区
	 * @return
	 */
	@RequestMapping(value="/api/provDistrt/getProvinceAll",method=RequestMethod.GET)
	public RestResultResponse getProvinceList(){
		List<BdpProvDistrtBasicDataVO> list = bdpProvDistrtBasisDataService.getProvinceAll();
		for(BdpProvDistrtBasicDataVO vo : list){
			vo.setNameWithCode(vo.getOrgBrnchNm()+" "+vo.getOrgBrnchId());
		}
		return this.buildSuccessRestResultResponse(list);
	}
	/**
	 * 分页查询省区/大区
	 * @param page
	 * @param size
	 * @param name
	 * @param queryType
	 * @return
	 */
	@RequestMapping(value="/api/provDistrt/getWithPage",method=RequestMethod.GET)
	public RestResultResponse getOrgBrnchWithPage(@RequestParam(value = "p", required = false, defaultValue = "1") int page,
			@RequestParam(value = "s", required = false, defaultValue = "10") int size
			,@RequestParam(value = "name", required = false) String name
			,@RequestParam(value = "lvl", required = false) String lvl){
		name = DecodeUtils.encodeStr(name);
		Map<String, Object> condition = new HashMap<String, Object>();
		if(StringUtils.isNotBlank(name)){
			if(name.matches("[a-zA-Z]+")){
				condition.put("orgBrnchPinyin", name.toUpperCase());
			}else {
				condition.put("orgBrnchNm", name);
			}
		}
		Pagination<BdpProvDistrtBasicDataVO> pageData = new Pagination<BdpProvDistrtBasicDataVO>(page, size);
		if(lvl.equals(Constants.ORG_BRNCH_LVL_PROVINCE_AREA)){//省区
			pageData = bdpProvDistrtBasisDataService.getProveWithPage(condition, PageUtils.getOffset(page, size), size);
		}else{// 大区
			pageData = bdpProvDistrtBasisDataService.getDictrtWithPage(condition, PageUtils.getOffset(page, size), size);
		}
		for(BdpProvDistrtBasicDataVO vo : pageData.getResult()){//根据层级code,设置层级中文名
			if(vo.getOrgBrnchLvlCd().equals(Constants.ORG_BRNCH_LVL_PROVINCE_AREA)){
				vo.setLvlNm(Constants.ORG_BRNCH_LVL_PROVINCE_AREA_NAME);
			}else if(vo.getOrgBrnchLvlCd().equals(Constants.ORG_BRNCH_LVL_DICT)){
				vo.setLvlNm(Constants.ORG_BRNCH_LVL_DICT_NAME);
			}
		}
		return this.buildSuccessRestResultResponse(pageData);
	}
	/**
	 * 更新省区/大区
	 * @param entity
	 * @return
	 */
	@RequestMapping(value="/api/provDistrt/update",method=RequestMethod.PUT)
	public RestResultResponse updateOrgBrnch(@RequestBody BdpProvDistrtBasicData entity){
		int result = bdpProvDistrtBasisDataService.updateProvDistrt(entity);
		return this.buildSuccessRestResultResponse(result);
	}
	/**
	 * （逻辑）删除省区/大区
	 * @param entity
	 * @return
	 */
	@RequestMapping(value="/api/provDistrt/changeStatus",method=RequestMethod.PUT)
	public RestResultResponse changeStatus(@RequestBody BdpProvDistrtBasicData entity){
		int result =  bdpProvDistrtBasisDataService.deleteProvDistrt(entity);
		return this.buildSuccessRestResultResponse(result);
	}
	/**
	 * 新增省区/大区
	 * @param entity
	 * @return
	 */
	@RequestMapping(value="/api/provDistrt/add",method=RequestMethod.POST)
	public RestResultResponse addOrgBrnch(@RequestBody BdpProvDistrtBasicData entity){
		int result = bdpProvDistrtBasisDataService.addProvDistrt(entity);
		return this.buildSuccessRestResultResponse(result);
	}
}
