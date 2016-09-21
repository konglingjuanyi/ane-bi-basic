package com.ane56.bi.port.adapter.web.resource.operate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.ane56.bi.application.BdpDstrbPlanOpTimeService;
import com.ane56.bi.common.data.RequestParameter;
import com.ane56.bi.common.pager.PageBean;
import com.ane56.bi.common.util.JSONUtils;
import com.ane56.bi.common.util.StringUtils;
import com.ane56.bi.domain.operation.BdpDstrbPlanOpTime;
import com.ane56.bi.port.adapter.rest.ResourceResponseSupport;
import com.ane56.bi.port.adapter.rest.RestResultResponse;
import com.ane56.bi.port.adapter.rest.RestResultStatus;

@RestController
@RequestMapping(value="plan")
public class BdpDstrbPlanOpTimeControll extends ResourceResponseSupport {

	@Autowired
	private BdpDstrbPlanOpTimeService bdpDstrbPlanOpTimeService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public RestResultResponse addData(@RequestBody BdpDstrbPlanOpTime data ) {
		String siteId = data.getSiteId();
		int result = 0;
		if(!StringUtils.isEmpty(siteId)){
			Map<String,Object> condition = new HashMap<String,Object>();
			condition.put("siteId", siteId);
			List<BdpDstrbPlanOpTime>  list = bdpDstrbPlanOpTimeService.findByParams(condition);
			if(CollectionUtils.isEmpty(list)){
				data.setSiteTypeCd("34343");
				data.setCrtUserId("34343");
				data.setCrtAppSysId("212121");
		      result = bdpDstrbPlanOpTimeService.addData(data);
			}else{
				result = -1;
			}
		}		
		return this.buildSuccessRestResultResponse(result);
	}
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public RestResultResponse deleteData(@RequestBody BdpDstrbPlanOpTime data) {
		String siteId = data.getSiteId();
		int result= 0 ;
		try {
			Map<String,Object> condition = new HashMap<String,Object>();
			condition.put("siteId", siteId);
			result = bdpDstrbPlanOpTimeService.deleteData(condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.buildSuccessRestResultResponse(result);
	}
	@RequestMapping(value = "/query",method = RequestMethod.POST)
	public RestResultResponse queryData() {
		Map<String,Object> condition = new HashMap<String,Object>();
		/*condition.put("kpiId", 1);*/
		List<BdpDstrbPlanOpTime> result = bdpDstrbPlanOpTimeService.findByParams(condition);
		return this.buildSuccessRestResultResponse(result);
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public RestResultResponse updateData(@RequestBody BdpDstrbPlanOpTime data) {
		int result = bdpDstrbPlanOpTimeService.updateData(data);
		return this.buildSuccessRestResultResponse(result);
	}
	@RequestMapping(value = "/queryDataByPage", method = RequestMethod.POST)
	public RestResultResponse queryDataByPage(@RequestBody RequestParameter  parameter) {
		String conditonStr = parameter.getSearch_condition();
		//页码
		int pageNum = parameter.getPageNum();
		//每页记录数
		int pageSize = parameter.getPageSize();
		Map<String,Object> condition = JSONUtils.convertJson2Object(conditonStr, HashMap.class);
		int offset = (pageNum-1)*pageSize;
		int limit = pageSize;
		PageBean<BdpDstrbPlanOpTime> result = bdpDstrbPlanOpTimeService.queryDataByPage(condition,offset,limit);
		result.setOffset(limit);
		result.setCurrent(pageNum);
		result.setPageSize(pageSize);
		System.out.println(JSON.toJSONString(result));
		RestResultResponse response = new RestResultResponse();
		response.setResult(JSON.toJSONString(result));
		response.setStatus(RestResultStatus.SUCCESS);
		return response;
	}
}
