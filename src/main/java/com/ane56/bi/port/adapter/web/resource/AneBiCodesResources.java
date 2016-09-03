package com.ane56.bi.port.adapter.web.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ane56.bi.application.AneBiCodesService;
import com.ane56.bi.domain.basic.AneBiCodes;
import com.ane56.bi.port.adapter.rest.ResourceResponseSupport;
import com.ane56.bi.port.adapter.rest.RestResultResponse;
import com.ane56.bi.port.adapter.utils.DecodeUtils;
import com.ane56.bi.port.adapter.utils.PageUtils;
import com.ane56.db.mybatis.core.Pagination;

@RestController
public class AneBiCodesResources extends ResourceResponseSupport{

	@Autowired
	private AneBiCodesService aneBiCodesService;
	/**
	 * 分页查询字典项
	 * @param page
	 * @param size
	 * @param codeType
	 * @param description
	 * @param codeName
	 * @return
	 */
	@RequestMapping(value = "/api/getCodesWithPage", method = RequestMethod.GET)
	public RestResultResponse getCodesWithPage(@RequestParam(value = "p", required = false, defaultValue = "1") int page,
			@RequestParam(value = "s", required = false, defaultValue = "10") int size
			,@RequestParam(value = "codeType", required = false) String codeType
			,@RequestParam(value = "description", required = false) String description
			,@RequestParam(value = "codeName", required = false) String codeName){
		codeType = DecodeUtils.encodeStr(codeType);
		description = DecodeUtils.encodeStr(description);
		codeName = DecodeUtils.encodeStr(codeName);
		Pagination<AneBiCodes> codes = aneBiCodesService.getCodesWithPage(PageUtils.getOffset(page, size), size,codeType,description,codeName);
		return this.buildSuccessRestResultResponse(codes);
	}
	/**
	 * 新增字典项
	 * @param aneBiCodes
	 * @return
	 */
	@RequestMapping(value = "/api/addCodes", method = RequestMethod.POST)
	public RestResultResponse addCodes(@RequestBody AneBiCodes aneBiCodes){
		AneBiCodes entity = aneBiCodesService.findCodeByTypeAndValue(aneBiCodes.getCodeType(), aneBiCodes.getCodeName());
		if(entity!=null){//已存在
			return this.buildSuccessRestResultResponse("新增失败,数据已存在");
		}
		aneBiCodesService.addCode(aneBiCodes);
		return this.buildSuccessRestResultResponse();
	}
	/**
	 * 更新字典项
	 * @param id
	 * @param aneBiCodes
	 * @return
	 */
	@RequestMapping(value = "/api/updateCodes/{id}", method = RequestMethod.PUT)
	public RestResultResponse updateCodes(@PathVariable long id,@RequestBody AneBiCodes aneBiCodes){
		AneBiCodes entity = aneBiCodesService.findCodeByTypeAndValue(aneBiCodes.getCodeType(), aneBiCodes.getCodeName());
		if(entity!=null&&entity.getId()!=id){//数据已存在，且与要更新的数据不是同一条
			return this.buildSuccessRestResultResponse("更新失败,数据重复");
		}
		aneBiCodesService.updateCode(aneBiCodes);
		return this.buildSuccessRestResultResponse();
	}
	/**
	 * 删除字典项
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/api/delCodes/{id}", method = RequestMethod.DELETE)
	public RestResultResponse delCodes(@PathVariable long id){
		AneBiCodes entity = aneBiCodesService.findById(id);
		aneBiCodesService.deleteCode(entity);
		return this.buildSuccessRestResultResponse();
	}
	/**
	 * 根据类型获取字典项list
	 * @param codeType
	 * @return
	 */
	@RequestMapping(value = "/api/getCodesByType", method = RequestMethod.GET)
	public RestResultResponse getCodesByType(@RequestParam(value = "codeType", required = true) String codeType){
		List<AneBiCodes> list = aneBiCodesService.getCodesByType(codeType);
		return this.buildSuccessRestResultResponse(list);
	}
	
}
