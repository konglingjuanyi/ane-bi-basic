package com.ane56.bi.port.adapter.web.resource.operate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ane56.bi.application.DimensionKpiService;
import com.ane56.bi.domain.operation.DimensionKpi;
import com.ane56.bi.port.adapter.rest.ResourceResponseSupport;
import com.ane56.bi.port.adapter.rest.RestResultResponse;

@RestController
@RequestMapping(value="dimsion")
public class DimensionKpiControll extends ResourceResponseSupport {

	@Autowired
	private DimensionKpiService DimensionKpiService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public RestResultResponse addKpiData() {
		DimensionKpi data = new DimensionKpi();
		data.setDimensionName("杭州大区");
		data.setKpiId(1);
		data.setDepartmentType("运维");
		data.setCreateTime(new Date());
		data.setCreatedName("杨得朝");
		data.setCreatedId(12121);
		data.setStatus(1);
		int result = DimensionKpiService.addDimensionKpiData(data);
		return this.buildSuccessRestResultResponse(result);
	}
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public RestResultResponse queryKpiData() {
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("dimensionId", 1);
		List<DimensionKpi> result = DimensionKpiService.findByParams(condition);
		return this.buildSuccessRestResultResponse(result);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public RestResultResponse updateKpiData() {
	
		DimensionKpi data = new DimensionKpi();
		data.setDimensionId(1);
		data.setDepartmentId(1);
		data.setDimensionName("杭州大区");
		data.setKpiId(1);
		data.setDepartmentType("运维");
		data.setCreateTime(new Date());
		data.setCreatedName("杨得朝");
		data.setCreatedId(12121);
		data.setUpdateTime(new Date());
		data.setStatus(1);
		int result = DimensionKpiService.updateDimensionKpiData(data);
		return this.buildSuccessRestResultResponse(result);
	}
}
