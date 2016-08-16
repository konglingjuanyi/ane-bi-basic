package com.ane56.bi.port.adapter.web.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ane56.bi.application.NationalplanschedulesService;
import com.ane56.bi.domain.basics.PlanSchedulesVO;
import com.ane56.bi.domain.user.User;
import com.ane56.bi.port.adapter.rest.ResourceResponseSupport;
import com.ane56.bi.port.adapter.rest.RestResultResponse;
import com.ane56.bi.port.adapter.utils.DecodeUtils;
import com.ane56.bi.port.adapter.utils.PageUtils;
import com.ane56.bi.port.adapter.web.resource.form.NationalplanscheduleForm;
import com.ane56.bi.port.adapter.web.resource.form.UserForm;
import com.ane56.db.mybatis.core.Pagination;

@RestController
public class NationalplanschedulesResources extends ResourceResponseSupport{

	@Autowired
	private NationalplanschedulesService nationalplanschedulesService;
	
	@RequestMapping(value = "/api/planschedulesWithPage", method = RequestMethod.GET)
	public RestResultResponse planschedulesWithPage(@RequestParam(value = "p", required = false, defaultValue = "1") int page,
			@RequestParam(value = "s", required = false, defaultValue = "2") int size,
			NationalplanscheduleForm form) {
		form.setDepartPlace(DecodeUtils.encodeStr(form.getDepartPlace()));//始发地
		form.setStopNames(DecodeUtils.encodeStr(form.getStopNames()));//经停地
		form.setDestination(DecodeUtils.encodeStr(form.getDestination()));//目的地
		form.setDepartPeriod(DecodeUtils.encodeStr(form.getDepartPeriod()));//发车周期
		form.setLoadType(DecodeUtils.encodeStr(form.getLoadType()));//装卸方式
		Pagination<PlanSchedulesVO> PlanSchedulesVO = nationalplanschedulesService.getPlanSchedulesWithPage(PageUtils.getOffset(page, size), size,form);
		return this.buildSuccessRestResultResponse(PlanSchedulesVO);
	}
}
