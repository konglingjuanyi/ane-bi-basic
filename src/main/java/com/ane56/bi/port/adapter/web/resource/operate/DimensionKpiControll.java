package com.ane56.bi.port.adapter.web.resource.operate;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ane56.bi.application.DimensionKpiService;
import com.ane56.bi.common.util.CreateExcelUtils;
import com.ane56.bi.common.util.DateUtils;
import com.ane56.bi.domain.operation.DimensionKpi;
import com.ane56.bi.domain.operation.mappper.DimensionKpiMapper;
import com.ane56.bi.port.adapter.rest.ResourceResponseSupport;
import com.ane56.bi.port.adapter.rest.RestResultResponse;

@RestController
@RequestMapping(value = "dimsion")
public class DimensionKpiControll extends ResourceResponseSupport {
	
	private static Logger log = Logger.getLogger(DimensionKpiControll.class);
	@Autowired
	private DimensionKpiService dimensionKpiService;

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
		int result = dimensionKpiService.addDimensionKpiData(data);
		return this.buildSuccessRestResultResponse(result);
	}

	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public RestResultResponse queryKpiData() {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("dimensionId", 1);
		List<DimensionKpi> result = dimensionKpiService.findByParams(condition);
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
		int result = dimensionKpiService.updateDimensionKpiData(data);
		return this.buildSuccessRestResultResponse(result);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public RestResultResponse deleteKpiData() {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("dimensionId", 1);
		int result = dimensionKpiService.deleteDimensionKpiData(condition);
		return this.buildSuccessRestResultResponse(result);
	};
	@RequestMapping(value = "/excel")
	public void exportExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> condition = new HashMap<String, Object>();
		Map<String, String> titleMap = null;
		//导出excel
		String fileName = "维度目标值_"+DateUtils.getDate(new Date());
		fileName = new String(fileName.getBytes("UTF-8"), "UTF-8");
		response.reset();
		response.setHeader("Content-Disposition", "attachment;fileName="+fileName+".xls");  
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		OutputStream output = response.getOutputStream();
		BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
		// 定义单元格报头
		String worksheetTitle = "维度目标值信息";
		titleMap = DimensionKpiMapper.getExcelTitle();
		//创建一个Excel文件  
		HSSFWorkbook wb = new HSSFWorkbook();
		List<Map<String, Object>> value = dimensionKpiService.exportEntities(condition);
		//创建一个Excel的Sheet    
		HSSFSheet sheet = CreateExcelUtils.createExcelTitleAndStyle(worksheetTitle, wb,titleMap,12);
		CreateExcelUtils.paraseDataToExcelSheet(value, sheet, titleMap);
		try {
			bufferedOutPut.flush();
			wb.write(bufferedOutPut);
			bufferedOutPut.close();
		} catch (IOException e) {
			log.error("导出维度目标值信息Excel异常"+e);
		} finally {
		}
	};
}
