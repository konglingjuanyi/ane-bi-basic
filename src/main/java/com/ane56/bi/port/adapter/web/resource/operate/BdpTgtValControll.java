package com.ane56.bi.port.adapter.web.resource.operate;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ane56.bi.application.BdpTgtValService;
import com.ane56.bi.common.data.RequestParameter;
import com.ane56.bi.common.pager.Pagination;
import com.ane56.bi.common.util.JSONUtils;
import com.ane56.bi.common.util.StringUtils;
import com.ane56.bi.domain.operation.BdpTgtVal;
import com.ane56.bi.port.adapter.rest.ResourceResponseSupport;
import com.ane56.bi.port.adapter.rest.RestResultResponse;

@RestController
@RequestMapping(value="target")
public class BdpTgtValControll extends ResourceResponseSupport {

	@Autowired
	private BdpTgtValService bdpTgtValService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public RestResultResponse addData(@RequestBody BdpTgtVal data ) {
		String orgBrnchId = data.getOrgBrnchId();
		int result = 0;
		if(!StringUtils.isEmpty(orgBrnchId)){
			HashMap<String,Object> condition = new HashMap<String,Object>();
			condition.put("orgBrnchId", orgBrnchId);
			List<BdpTgtVal>  list = bdpTgtValService.findByParams(condition);
			if(CollectionUtils.isEmpty(list)){
				data.setCrtUserId("34343");
				data.setCrtAppSysId("212121");
		        result = bdpTgtValService.addData(data);
			}else{
				result = -1;
			}
		}		
		return this.buildSuccessRestResultResponse(result);
	}
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public RestResultResponse deleteData(@RequestBody BdpTgtVal data) {
		String orgBrnchId = data.getOrgBrnchId();
		int result= 0 ;
			try {
				HashMap<String,Object> condition = new HashMap<String,Object>();
				condition.put("orgBrnchId", orgBrnchId);
				result = bdpTgtValService.deleteData(condition);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return this.buildSuccessRestResultResponse(result);
	}
	@RequestMapping(value = "/query",method = RequestMethod.POST)
	public RestResultResponse queryData() {
		HashMap<String,Object> condition = new HashMap<String,Object>();
		List<BdpTgtVal> result = bdpTgtValService.findByParams(condition);
		return this.buildSuccessRestResultResponse(result);
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public RestResultResponse updateData(@RequestBody BdpTgtVal data) {
		int result = bdpTgtValService.updateData(data);
		return this.buildSuccessRestResultResponse(result);
	}
	@RequestMapping(value = "/queryDataByPage", method = RequestMethod.POST)
	public RestResultResponse queryDataByPage(@RequestBody RequestParameter  parameter) {
		String conditonStr = parameter.getSearch_condition();
		//页码
		int pageNum = parameter.getPageNum();
		//每页记录数
		int pageSize = parameter.getPageSize();
		@SuppressWarnings("unchecked")
		HashMap<String, Object> condition = JSONUtils.convertJson2Object(conditonStr, HashMap.class);
		Pagination<BdpTgtVal> result = bdpTgtValService.queryDataByPage(condition,pageNum,pageSize);
		return this.buildSuccessRestResultResponse(result);
	}
}
