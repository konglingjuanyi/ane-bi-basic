package com.ane56.bi.port.adapter.web.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ane56.bi.application.AneBiSiteRadioStandardService;
import com.ane56.bi.domain.radio.AneBiSiteRadioStandard;
import com.ane56.bi.port.adapter.rest.ResourceResponseSupport;
import com.ane56.bi.port.adapter.rest.RestResultResponse;

@RestController
public class AneBiSiteRadioStandardResources extends ResourceResponseSupport{
	
	@Autowired
	private AneBiSiteRadioStandardService aneBiSiteRadioStandardService;
	
	/**
	 * 获取比例标准
	 * @return
	 */
	@RequestMapping(value = "/api/getRadio", method = RequestMethod.GET)
	public RestResultResponse getRadio() {
		List<AneBiSiteRadioStandard> list = aneBiSiteRadioStandardService.getRadio();
		return this.buildSuccessRestResultResponse(list);
	}
	
	/**
	 * 新增比例标准
	 * @param radio
	 * @return
	 */
	@RequestMapping(value = "/api/createRadio/{radio:.+}", method = RequestMethod.POST)
	public RestResultResponse createRadio(@PathVariable Double radio){
		aneBiSiteRadioStandardService.createRadio(radio);
		return this.buildSuccessRestResultResponse();
	}
	
	/**
	 * 更新比例标准
	 * @param radio
	 * @return
	 */
	@RequestMapping(value = "/api/updateRadio/{radio:.+}", method = RequestMethod.PUT)
	public RestResultResponse updateRadio(@PathVariable Double radio){
		aneBiSiteRadioStandardService.updateRadio(radio);
		return this.buildSuccessRestResultResponse();
	}
}
