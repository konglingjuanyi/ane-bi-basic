package com.ane56.dispatch.application;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ane56.bi.application.AneBiCodesService;
import com.ane56.bi.domain.basic.AneBiCodes;
import com.ane56.dispatch.AbstractTest;

public class CodesServiceTest extends AbstractTest{
	
	@Autowired
	private AneBiCodesService aneBiCodesService;
	
	@Test
	public void queryTest(){
		String codeType = "aging_type";
//		List<AneBiCodes> list = aneBiCodesService.getCodesByType(codeType);
//		for(AneBiCodes codes : list){
//			System.err.println(codes.getCodeName());
//		}
		AneBiCodes aneBiCodes = aneBiCodesService.findCodeByTypeAndValue(codeType, "1");
		System.err.println(aneBiCodes.getCodeName());
	}

}
