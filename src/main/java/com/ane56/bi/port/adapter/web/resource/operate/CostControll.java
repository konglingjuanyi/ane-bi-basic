package com.ane56.bi.port.adapter.web.resource.operate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ane56.bi.application.CostService;
import com.ane56.bi.domain.operation.Cost;
import com.ane56.bi.port.adapter.rest.ResourceResponseSupport;
import com.ane56.bi.port.adapter.rest.RestResultResponse;

@RestController
@RequestMapping(value="cost")
public class CostControll extends ResourceResponseSupport {

	@Autowired
	private CostService costService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public RestResultResponse addCostData() {
		Cost data = new Cost();
		data.setCostName("燃油费");
		data.setCreateTime(new Date());
		data.setStatus(1);
		int result = costService.addCostData(data);
		return this.buildSuccessRestResultResponse(result);
	}
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public RestResultResponse queryCostData() {
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("costId", 1);
		List<Cost> result = costService.findByParams(condition);
		return this.buildSuccessRestResultResponse(result);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public RestResultResponse updateCostData() {
		Cost data = new Cost();
		data.setCostId(1);
		data.setCostName("燃油费更新");
		data.setCreateTime(new Date());
		data.setStatus(1);
		int result = costService.updateCostData(data);
		return this.buildSuccessRestResultResponse(result);
	}
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public RestResultResponse deleteCostData() {
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("costId", 1);
		int result = costService.deleteCostData(condition);
		return this.buildSuccessRestResultResponse(result);
	}
}
