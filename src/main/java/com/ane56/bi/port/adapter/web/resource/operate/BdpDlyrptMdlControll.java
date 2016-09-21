package com.ane56.bi.port.adapter.web.resource.operate;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ane56.bi.application.BdpDlyrptMdlService;
import com.ane56.bi.common.data.RequestParameter;
import com.ane56.bi.common.pager.Pagination;
import com.ane56.bi.common.util.JSONUtils;
import com.ane56.bi.common.util.StringUtils;
import com.ane56.bi.domain.operation.BdpDlyrptMdl;
import com.ane56.bi.port.adapter.rest.ResourceResponseSupport;
import com.ane56.bi.port.adapter.rest.RestResultResponse;

@RestController
@RequestMapping(value="module")
public class BdpDlyrptMdlControll extends ResourceResponseSupport {

	@Autowired
	private BdpDlyrptMdlService bdpDlyrptMdlService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public RestResultResponse addData(@RequestBody BdpDlyrptMdl data ) {
		String mdlNm = data.getMdlNm();
		int result = 0;
		if(!StringUtils.isEmpty(mdlNm)){
			HashMap<String,Object> condition = new HashMap<String,Object>();
			condition.put("mdlNm", mdlNm);
			List<BdpDlyrptMdl>  list = bdpDlyrptMdlService.findByParams(condition);
			if(CollectionUtils.isEmpty(list)){
				data.setCrtUserId("34343");
				data.setCrtAppSysId("212121");
				data.setValidFlag("1");
		      result = bdpDlyrptMdlService.addData(data);
			}else{
				result = -1;
			}
		}		
		return this.buildSuccessRestResultResponse(result);
	}
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public RestResultResponse deleteData(@RequestBody BdpDlyrptMdl data) {
		String mdlId = data.getMdlId();
		int result= 0 ;
			try {
				HashMap<String,Object> condition = new HashMap<String,Object>();
				condition.put("mdlId", mdlId);
				result = bdpDlyrptMdlService.deleteData(condition);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return this.buildSuccessRestResultResponse(result);
	}
	@RequestMapping(value = "/query",method = RequestMethod.POST)
	public RestResultResponse queryData() {
		HashMap<String,Object> condition = new HashMap<String,Object>();
		/*condition.put("kpiId", 1);*/
		List<BdpDlyrptMdl> result = bdpDlyrptMdlService.findByParams(condition);
		return this.buildSuccessRestResultResponse(result);
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public RestResultResponse updateData(@RequestBody BdpDlyrptMdl data) {
		int result = bdpDlyrptMdlService.updateData(data);
		return this.buildSuccessRestResultResponse(result);
	}
	@RequestMapping(value = "/queryDataByPage", method = RequestMethod.POST)
	public RestResultResponse queryDataByPage(@RequestBody RequestParameter  parameter) {
		String conditonStr = parameter.getSearch_condition();
		//页码
		int pageNum = parameter.getPageNum();
		//每页记录数
		int pageSize = parameter.getPageSize();
		HashMap condition = JSONUtils.convertJson2Object(conditonStr, HashMap.class);
		Pagination<BdpDlyrptMdl> result = bdpDlyrptMdlService.queryDataByPage(condition,pageNum,pageSize);
		return this.buildSuccessRestResultResponse(result);
	}
}
