package com.ane56.bi.application;

import java.util.Date;
import java.util.List;

import com.ane56.bi.domain.AssertionConcern;
import com.ane56.bi.domain.radio.AneBiSiteRadioStandard;
import com.ane56.bi.domain.radio.AneBiSiteRadioStandardRepository;
import com.ane56.bi.port.adapter.utils.IdUtils;

@Service
public class AneBiSiteRadioStandardService extends AssertionConcern{
	
	@Autowired
	private AneBiSiteRadioStandardRepository aneBiSiteRadioStandardRepository;

	/**
	 * 获取比例标准
	 * @return
	 */
	public List<AneBiSiteRadioStandard> getRadio(){
		return aneBiSiteRadioStandardRepository.getRadio();
	}
	
	/**
	 * 新增比例标准
	 * @param radio
	 * @return
	 */
	public void createRadio(Double radio){
		AneBiSiteRadioStandard entity = new AneBiSiteRadioStandard();
		entity.setId(IdUtils.id());
		entity.setRadio(radio);
		entity.setCreateTime(new Date());
		entity.setUpdateTime(new Date());
		aneBiSiteRadioStandardRepository.createRadio(entity);
	}
	
	/**
	 * 更新比例标准
	 * @param radio
	 */
	public void updateRadio(Double radio){
		List<AneBiSiteRadioStandard> list = aneBiSiteRadioStandardRepository.getRadio();
		for(AneBiSiteRadioStandard srs : list){
			srs.setRadio(radio);
			aneBiSiteRadioStandardRepository.updateRadio(srs);
		}
	}
	
	/**
	 * 获取比例标准值
	 * @return
	 */
	public Double getValueOfRadio(){
		AneBiSiteRadioStandard entity = getRadio().get(0);
		return entity.getRadio();
	}
}
