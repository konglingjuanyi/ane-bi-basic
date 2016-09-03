package com.ane56.bi.port.adapter.web.resource.operate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ane56.bi.application.PlanTimeService;
import com.ane56.bi.common.pager.PageBean;
import com.ane56.bi.common.pager.PageConstants;
import com.ane56.bi.domain.operation.PlanTime;
import com.ane56.bi.port.adapter.rest.ResourceResponseSupport;
import com.ane56.bi.port.adapter.rest.RestResultResponse;

@RestController
@RequestMapping(value="plan")
public class PlanTimeControll extends ResourceResponseSupport {

	@Autowired
	private PlanTimeService planTimeService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public RestResultResponse addPlanTime() {
		PlanTime data = new PlanTime();
		data.setSiteId(12121);
		data.setSiteName("上海分拨中心");
		data.setCreateTime(new Date());
		data.setCreatedName("杨得朝");
		data.setStatus(1);
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("kpiId", 1);
		int result = planTimeService.addPlanTime(data);
		return this.buildSuccessRestResultResponse(result);
	}
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public RestResultResponse queryPlanTime() {
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("kpiId", 1);
		List<PlanTime> result = planTimeService.findByParams(condition);
		return this.buildSuccessRestResultResponse(result);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public RestResultResponse updatePlanTime() {
		PlanTime data = new PlanTime();
		data.setOperationId(1);
		data.setSiteId(12121);
		data.setSiteName("上海分拨中心更新");
		data.setCreateTime(new Date());
		data.setStatus(1);
		data.setCreateTime(new Date());
		data.setCreatedName("杨得朝更新");
		data.setUpdateTime(new Date());
		data.setStatus(1);
		int result = planTimeService.updatePlanTime(data);
		return this.buildSuccessRestResultResponse(result);
	}
	@RequestMapping(value = "/queryDataByPage", method = RequestMethod.GET)
	public RestResultResponse queryDataByPage() {
		Map<String,Object> condition = new HashMap<String,Object>();
		//condition.put("kpiId", 1);
		//每页记录数
		int pageSize = PageConstants.PAGE_SIZE;
		//页码
		int currentPage = 2;
		int offset = (currentPage-1)*pageSize;
		int limit = pageSize;
		PageBean<PlanTime> result = planTimeService.queryDataByPage(condition,offset,limit);
		result.setCurrentPage(currentPage);
		result.setPageSize(pageSize);
		return this.buildSuccessRestResultResponse(result);
	}
}
