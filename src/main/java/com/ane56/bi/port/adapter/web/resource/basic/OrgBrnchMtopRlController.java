package com.ane56.bi.port.adapter.web.resource.basic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ane56.bi.application.OrgBrnchMtopRlService;
import com.ane56.bi.domain.basic.OrgBrnchQueryVO;
import com.ane56.bi.port.adapter.rest.ResourceResponseSupport;
import com.ane56.bi.port.adapter.rest.RestResultResponse;
import com.ane56.bi.port.adapter.utils.DecodeUtils;
import com.ane56.bi.port.adapter.utils.PageUtils;
import com.ane56.db.mybatis.core.Pagination;
/**
 * 组织架构管理控制层
 * @author 张一波
 *
 */
@RestController
public class OrgBrnchMtopRlController extends ResourceResponseSupport{
	@Autowired
	private OrgBrnchMtopRlService orgBrnchMtopRlService;
	/**
	 * 分页查询组织结构
	 * @param page
	 * @param size
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/api/MtopRl/getOrgBrnchMtopRl", method = RequestMethod.GET)
	public RestResultResponse getOrgBrnchMtopRl(@RequestParam(value = "p", required = false, defaultValue = "1") int page,
			@RequestParam(value = "s", required = false, defaultValue = "10") int size,
			OrgBrnchQueryVO vo){
		vo.setAreaName(DecodeUtils.encodeStr(vo.getAreaName()));
		vo.setProvinceName(DecodeUtils.encodeStr(vo.getProvinceName()));
		vo.setDictName(DecodeUtils.encodeStr(vo.getDictName()));
		vo.setSiteName(DecodeUtils.encodeStr(vo.getSiteName()));
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("siteName", vo.getSiteName());
		condition.put("dictName", vo.getDictName());
		condition.put("provinceName", vo.getProvinceName());
		condition.put("areaName", vo.getAreaName());
		Pagination<OrgBrnchQueryVO> pageData = orgBrnchMtopRlService.getMtopRlWithPage(condition, PageUtils.getOffset(page, size), size);
		return this.buildSuccessRestResultResponse(pageData);
	}
	/**
	 * 查询区域
	 * @return
	 */
	@RequestMapping(value = "/api/MtopRl/getArea", method = RequestMethod.GET)
	public RestResultResponse getArea(){
		List<OrgBrnchQueryVO> list = orgBrnchMtopRlService.getAreaAll();
		for(OrgBrnchQueryVO vo : list){
			vo.setArea(vo.getAreaName()+" "+vo.getAreaId());
		}
		return this.buildSuccessRestResultResponse(list);
	}
	/**
	 * 查询运营省区
	 * @return
	 */
	@RequestMapping(value = "/api/MtopRl/getProvinceArea", method = RequestMethod.GET)
	public RestResultResponse getProvinceArea(){
		List<OrgBrnchQueryVO> list = orgBrnchMtopRlService.getProvAll();
		for(OrgBrnchQueryVO vo : list){
			vo.setProvince(vo.getProvinceName()+" "+vo.getProvinceId());
		}
		return this.buildSuccessRestResultResponse(list);
	}
	/**
	 * 查询运营大区
	 * @return
	 */
	@RequestMapping(value = "/api/MtopRl/getDict", method = RequestMethod.GET)
	public RestResultResponse getDict(){
		List<OrgBrnchQueryVO> list = orgBrnchMtopRlService.getDistrtAll();
		for(OrgBrnchQueryVO vo : list){
			vo.setDict(vo.getDictName()+" "+vo.getDictId());
		}
		return this.buildSuccessRestResultResponse(list);
	}
	/**
	 * 查询分拨
	 * @return
	 */
	@RequestMapping(value = "/api/MtopRl/getSite", method = RequestMethod.GET)
	public RestResultResponse getSite(){
		List<OrgBrnchQueryVO> list = orgBrnchMtopRlService.getSiteAll();
		for(OrgBrnchQueryVO vo : list){
			vo.setSite(vo.getSiteName()+" "+vo.getSiteId());
		}
		return this.buildSuccessRestResultResponse(list);
	}
	/**
	 * 修改组织架构关系
	 * @param upAreaId
	 * @param upProvinceAreaId
	 * @param upDictId
	 * @param upSiteId
	 * @param oriData
	 * @return
	 */
	@RequestMapping(value = "/api/MtopRl/saveOrg/{upAreaId}/{upProvinceId}/{upDictId}/{upSiteId}", method = RequestMethod.PUT)
	@ResponseBody
	public RestResultResponse saveOrg(@PathVariable String upAreaId,@PathVariable String upProvinceId
			,@PathVariable String upDictId,@PathVariable String upSiteId,@RequestBody OrgBrnchQueryVO oriData){
		OrgBrnchQueryVO upData = new OrgBrnchQueryVO();
		upData.setAreaId(upAreaId);
		upData.setProvinceId(upProvinceId);
		upData.setDictId(upDictId);
		upData.setSiteId(upSiteId);
		int	result = orgBrnchMtopRlService.saveOrgBrnchMtopRl(oriData, upData);
		return this.buildSuccessRestResultResponse(result);
	}
	
}
