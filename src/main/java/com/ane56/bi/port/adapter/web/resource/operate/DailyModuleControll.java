package com.ane56.bi.port.adapter.web.resource.operate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ane56.bi.application.DailyModuleService;
import com.ane56.bi.domain.operation.DailyModule;
import com.ane56.bi.port.adapter.rest.ResourceResponseSupport;
import com.ane56.bi.port.adapter.rest.RestResultResponse;

@RestController
@RequestMapping(value="module")
public class DailyModuleControll extends ResourceResponseSupport {

	@Autowired
	private DailyModuleService dailyModuleService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public RestResultResponse addKpiData() {
		DailyModule data = new DailyModule();
		data.setModuleName("模块1");
		data.setModuleOrder(1);
		data.setCreateTime(new Date());
		data.setCreatedName("杨得朝");
		data.setCreatedId(12121);
		data.setStatus(1);
		int result = dailyModuleService.addDailyModuleData(data);
		return this.buildSuccessRestResultResponse(result);
	}
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public RestResultResponse queryKpiData() {
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("moduleId", 1);
		List<DailyModule> result = dailyModuleService.findByParams(condition);
		return this.buildSuccessRestResultResponse(result);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public RestResultResponse updateKpiData() {
	
		DailyModule data = new DailyModule();
		data.setModuleId(1);
		data.setModuleName("模块13");
		data.setCreateTime(new Date());
		data.setCreatedName("杨得朝");
		data.setCreatedId(12121);
		data.setStatus(1);
		int result = dailyModuleService.updateDailyModuleData(data);
		return this.buildSuccessRestResultResponse(result);
	}
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public RestResultResponse deleteKpiData() {
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("moduleId", 1);
		int result = dailyModuleService.deleteDailyModuleData(condition);
		return this.buildSuccessRestResultResponse(result);
	}
}
