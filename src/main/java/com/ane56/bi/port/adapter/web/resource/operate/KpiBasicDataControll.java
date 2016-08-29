package com.ane56.bi.port.adapter.web.resource.operate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ane56.bi.application.KpiBasicDataService;
import com.ane56.bi.domain.operation.KpiBasicData;
import com.ane56.bi.port.adapter.rest.ResourceResponseSupport;
import com.ane56.bi.port.adapter.rest.RestResultResponse;

@RestController
@RequestMapping(value="kpi")
public class KpiBasicDataControll extends ResourceResponseSupport {

	@Autowired
	private KpiBasicDataService kpiBasicDataService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public RestResultResponse addKpiData() {
		KpiBasicData data = new KpiBasicData();
		data.setKpiName("万票遗失率");
		data.setKpiSimpleName("wpysl");
		data.setKpiType(1);
		data.setCreateTime(new Date());
		data.setCreatedName("杨得朝");
		data.setStatus(1);
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("kpiId", 1);
		int result = kpiBasicDataService.addKpiData(data);
		return this.buildSuccessRestResultResponse(result);
	}
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public RestResultResponse queryKpiData() {
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("kpiId", 1);
		List<KpiBasicData> result = kpiBasicDataService.findByParams(condition);
		return this.buildSuccessRestResultResponse(result);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public RestResultResponse updateKpiData() {
		KpiBasicData data = new KpiBasicData();
		data.setKpiId(1);
		data.setKpiName("万票遗失率3");
		data.setKpiSimpleName("wpysl");
		data.setKpiType(1);
		data.setCreateTime(new Date());
		data.setCreatedName("杨得朝");
		data.setUpdateTime(new Date());
		data.setUpdatedName("更新");
		data.setStatus(1);
		int result = kpiBasicDataService.updateKpiData(data);
		return this.buildSuccessRestResultResponse(result);
	}
}
