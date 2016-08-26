package com.ane56.bi.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ane56.bi.domain.basic.AneBiCodes;
import com.ane56.bi.domain.basic.AneBiCodesRepository;

@Service
public class AneBiCodesService {

	@Autowired
	private AneBiCodesRepository aneBiCodesRepository;
	/**
	 * 根据编码类型查询字典项
	 * @param codeType
	 * @return
	 */
	public List<AneBiCodes> getCodesByType(String codeType){
		return aneBiCodesRepository.getCodesByType(codeType);
	}
	/**
	 * 根据编码类型和编码值查询对应字典项
	 * @param codeType
	 * @param codeValue
	 * @return
	 */
	public AneBiCodes findCodeByTypeAndValue(String codeType,int codeValue){
		return aneBiCodesRepository.findCodeByTypeAndValue(codeType, codeValue);
	}
}
