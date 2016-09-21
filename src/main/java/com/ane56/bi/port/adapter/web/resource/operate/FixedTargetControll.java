package com.ane56.bi.port.adapter.web.resource.operate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ane56.bi.application.FixedTargetService;
import com.ane56.bi.common.pager.PageBean;
import com.ane56.bi.common.pager.PageConstants;
import com.ane56.bi.domain.operation.BdpTgtVal;
import com.ane56.bi.port.adapter.rest.ResourceResponseSupport;
import com.ane56.bi.port.adapter.rest.RestResultResponse;

@RestController
@RequestMapping(value="fixtarget")
public class FixedTargetControll extends ResourceResponseSupport {

	@Autowired
	private FixedTargetService fixedTargetService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public RestResultResponse addFixedTarget(@RequestBody BdpTgtVal data) {
	
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("kpiId", 1);
		int result = fixedTargetService.addFixedTarget(data);
		return this.buildSuccessRestResultResponse(result);
	}
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public RestResultResponse queryFixedTarget() {
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("fixedTargetId", 1);
		List<BdpTgtVal> result = fixedTargetService.findByParams(condition);
		return this.buildSuccessRestResultResponse(result);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public RestResultResponse updateFixedTarget(@RequestBody BdpTgtVal data) {
		int result = fixedTargetService.updateFixedTarget(data);
		return this.buildSuccessRestResultResponse(result);
	}
	@RequestMapping(value = "/queryDataByPage", method = RequestMethod.POST)
	public RestResultResponse queryDataByPage(@RequestBody BdpTgtVal data) {
		Map<String,Object> condition = new HashMap<String,Object>();
		//condition.put("kpiId", 1);
		//每页记录数
		int pageSize = PageConstants.PAGE_SIZE;
		//页码
		int currentPage = 2;
		int offset = (currentPage-1)*pageSize;
		int limit = pageSize;
		PageBean<BdpTgtVal> result = fixedTargetService.queryDataByPage(condition,offset,limit);
		result.setCurrent(currentPage);
		result.setPageSize(pageSize);
		return this.buildSuccessRestResultResponse(result);
	}
}
