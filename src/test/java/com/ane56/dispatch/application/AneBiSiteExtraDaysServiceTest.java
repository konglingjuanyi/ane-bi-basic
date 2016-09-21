package com.ane56.dispatch.application;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ane56.bi.application.AneBiSiteExtraDaysService;
import com.ane56.bi.domain.extraDays.AneBiSiteExtraDays;
import com.ane56.dispatch.AbstractTest;

public class AneBiSiteExtraDaysServiceTest extends AbstractTest{
	
	@Autowired
	private AneBiSiteExtraDaysService aneBiSiteExtraDaysService;
	
	@Test
	public void testAdd(){
		//add
		AneBiSiteExtraDays entity = new AneBiSiteExtraDays("网点名","网点", "一级网点", "交件时效", -2, "备注");
		aneBiSiteExtraDaysService.addExtraDay(entity);
		System.err.println("add:"+entity.getId()+","+entity.getSiteName());
		//update
		entity.update("网点更新", "网点2", "二级网点", "派件时效", +1, "隔天发");
		aneBiSiteExtraDaysService.updateExtraDay(entity);
		System.err.println("update:"+entity.getId()+","+entity.getSiteName());
		//find
		List<AneBiSiteExtraDays> list = aneBiSiteExtraDaysService.getExtraDaysAll();
		System.err.println("list:"+list.size());
		//delete
		aneBiSiteExtraDaysService.deleteExtraDay(entity);
		List<AneBiSiteExtraDays> list2 = aneBiSiteExtraDaysService.getExtraDaysAll();
		System.err.println("delete:"+list.size());
	}

}
