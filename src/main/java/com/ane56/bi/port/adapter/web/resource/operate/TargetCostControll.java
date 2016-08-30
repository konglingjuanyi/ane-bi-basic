package com.ane56.bi.port.adapter.web.resource.operate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ane56.bi.application.TargetCostService;
import com.ane56.bi.domain.operation.TargetCost;
import com.ane56.bi.port.adapter.rest.ResourceResponseSupport;
import com.ane56.bi.port.adapter.rest.RestResultResponse;

@RestController
@RequestMapping(value="target")
public class TargetCostControll extends ResourceResponseSupport {

	@Autowired
	private TargetCostService targetCostService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public RestResultResponse addTargetCostData() {
		TargetCost data = new TargetCost();
		data.setTargetName("网络增值业务");
		data.setIncomeMark(1);
		data.setPriceMark(1);
		data.setCreateTime(new Date());
		data.setCreatedName("杨得朝");
		data.setCreatedId(12121);
		data.setStatus(1);
		int result = targetCostService.addTargetCostData(data);
		return this.buildSuccessRestResultResponse(result);
	}
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public RestResultResponse queryTargetCostData() {
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("targetId", 1);
		List<TargetCost> result = targetCostService.findByParams(condition);
		return this.buildSuccessRestResultResponse(result);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public RestResultResponse updateTargetCostData() {
	
		TargetCost data = new TargetCost();
		data.setTargetId(1);
		data.setTargetName("网络增值业务update");
		data.setCreateTime(new Date());
		data.setCreatedName("杨得朝");
		data.setCreatedId(12121);
		data.setStatus(1);
		int result = targetCostService.updateTargetCostData(data);
		return this.buildSuccessRestResultResponse(result);
	}
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public RestResultResponse deleteTargetCostData() {
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("targetId", 1);
		int result = targetCostService.deleteTargetCostData(condition);
		return this.buildSuccessRestResultResponse(result);
	}
}
