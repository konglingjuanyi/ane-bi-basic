package com.ane56.bi.domain.operation.mappper;

import java.util.LinkedHashMap;
import java.util.Map;
public class DimensionKpiMapper{
	private static Map<String, String> titleMap = getExcelTitle();
	public static Map<String, String> getExcelTitle() {
		if (titleMap == null)
		{
			titleMap = new LinkedHashMap<String, String>();
		}
		else
		{
			titleMap.put("dimensionId", "主键标识");
			titleMap.put("dimensionName", "维度名称");
		    titleMap.put("kpiId", "kpi标识");
		    titleMap.put("dimensionType", "维度类别");
		    titleMap.put("objDate", "月份");
		    titleMap.put("targetValue", "目标值");
		    titleMap.put("departmentId", "部门编号");
		    titleMap.put("departmentType", "部门类别");
		    titleMap.put("createTime", "创建时间");
		    titleMap.put("updateTime", "修改时间");
		    titleMap.put("createdName", "创建人");
		    titleMap.put("status", "状态");
		}
		return titleMap;
	}
}