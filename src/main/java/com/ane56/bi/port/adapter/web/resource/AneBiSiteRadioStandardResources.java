package com.ane56.bi.port.adapter.web.resource;

import java.util.List;

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
