package com.ane56.bi.port.adapter.web.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ane56.bi.application.AneBiSiteExtraDaysService;
import com.ane56.bi.domain.extraDays.AneBiSiteExtraDays;
import com.ane56.bi.port.adapter.rest.ResourceResponseSupport;
import com.ane56.bi.port.adapter.rest.RestResultResponse;
import com.ane56.bi.port.adapter.utils.DecodeUtils;
import com.ane56.bi.port.adapter.utils.PageUtils;
import com.ane56.db.mybatis.core.Pagination;

@RestController
public class AneBiSiteExtraDaysResource extends ResourceResponseSupport{

	@Autowired
	private AneBiSiteExtraDaysService aneBiSiteExtraDaysService;
	
	/**
	 * 分页查询全国时效额外天数
	 * @param page
	 * @param size
	 * @param siteName
	 * @param agingtype
	 * @return
	 */
	@RequestMapping(value = "/api/getExtradays", method = RequestMethod.GET)
	public RestResultResponse getExtradays(@RequestParam(value = "p", required = false, defaultValue = "1") int page,
			@RequestParam(value = "s", required = false, defaultValue = "10") int size
			,@RequestParam(value = "siteName", required = false) String siteName
			,@RequestParam(value = "agingType", required = false) String agingType){
		siteName = DecodeUtils.encodeStr(siteName);
		agingType = DecodeUtils.encodeStr(agingType);
		Pagination<AneBiSiteExtraDays> sed = aneBiSiteExtraDaysService.getExtraDaysWithPage(PageUtils.getOffset(page, size), size,siteName,agingType);
		return this.buildSuccessRestResultResponse(sed);
	}
	/**
	 * 新增全国时效额外天数
	 * @param sed
	 * @return
	 */
	@RequestMapping(value = "/api/addExtradays", method = RequestMethod.POST)
	public RestResultResponse addExtradays(@RequestBody AneBiSiteExtraDays sed){
		//查看数据是否已存在
		AneBiSiteExtraDays entity = aneBiSiteExtraDaysService.findIsExit(sed.getSiteName(), sed.getAgingType());
		if(entity!=null){//已存在
			return this.buildSuccessRestResultResponse("新增失败,数据已存在");
		}
		aneBiSiteExtraDaysService.addExtraDay(sed);
		return this.buildSuccessRestResultResponse();
	}
	/**
	 * 更新全国时效额外天数
	 * @param id
	 * @param sed
	 * @return
	 */
	@RequestMapping(value = "/api/updateExtradays/{id}", method = RequestMethod.PUT)
	public RestResultResponse updateExtradays(@PathVariable long id,@RequestBody AneBiSiteExtraDays sed){
		//查看数据是否已存在
		AneBiSiteExtraDays entity = aneBiSiteExtraDaysService.findIsExit(sed.getSiteName(), sed.getAgingType());
		if(entity!=null&&entity.getId()!=id){//数据已存在，且与要更新的数据不是同一条
			return this.buildSuccessRestResultResponse("更新失败,数据重复");
		}
		aneBiSiteExtraDaysService.updateExtraDay(sed);
		return this.buildSuccessRestResultResponse();
	}
	/**
	 * (物理)删除全国时效额外天数
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/api/delExtradays/{id}", method = RequestMethod.DELETE)
	public RestResultResponse delExtradays(@PathVariable long id){
		AneBiSiteExtraDays entity = aneBiSiteExtraDaysService.findById(id);
		aneBiSiteExtraDaysService.deleteExtraDay(entity);
		return this.buildSuccessRestResultResponse();
	}
}
