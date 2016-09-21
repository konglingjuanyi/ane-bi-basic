package com.ane56.bi.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ane56.bi.domain.extraDays.AneBiSiteExtraDays;
import com.ane56.bi.domain.extraDays.AneBiSiteExtraDaysRepository;
import com.ane56.db.mybatis.core.Pagination;

@Service
public class AneBiSiteExtraDaysService {

	@Autowired
	private AneBiSiteExtraDaysRepository aneBiSiteExtraDaysRepository;
	
	/**
	 * 获取全国时效额外天数list
	 * @return
	 */
	public List<AneBiSiteExtraDays> getExtraDaysAll(){
		return aneBiSiteExtraDaysRepository.getExtraDaysAll();
	}
	/**
	 * 分页查询全国时效额外天数
	 * @return
	 */
	public Pagination<AneBiSiteExtraDays> getExtraDaysWithPage(int start,int limit,String siteName,String agingType){
		return aneBiSiteExtraDaysRepository.getExtraDaysWithPage(start,limit,siteName,agingType);
	}
	/**
	 * 新增全国时效额外天数
	 * @param entity
	 */
	public void addExtraDay(AneBiSiteExtraDays entity){
		AneBiSiteExtraDays sed = new AneBiSiteExtraDays(entity.getSiteName(),entity.getSiteProperty(), 
				entity.getType(), entity.getAgingType(), entity.getExtraDays(), entity.getMemo());
		aneBiSiteExtraDaysRepository.addExtraDay(sed);
	}
	/**
	 * 更新全国时效额外天数
	 * @param entity
	 */
	public void updateExtraDay(AneBiSiteExtraDays entity){
		AneBiSiteExtraDays sed = aneBiSiteExtraDaysRepository.findById(entity.getId());
		sed.update(entity.getSiteName(), entity.getSiteProperty(), entity.getType(),
				entity.getAgingType(), entity.getExtraDays(), entity.getMemo());
		aneBiSiteExtraDaysRepository.updateExtraDay(sed);
	}
	/**
	 * (物理)删除全国时效额外天数
	 * @param entity
	 */
	public void deleteExtraDay(AneBiSiteExtraDays entity){
		aneBiSiteExtraDaysRepository.deleteExtraDay(entity);
	}
	/**
	 * 根据id查询全国时效额外天数
	 * @param id
	 * @return
	 */
	public AneBiSiteExtraDays findById(long id){
		return aneBiSiteExtraDaysRepository.findById(id);
	}
	/**
	 * 根据网点名称,时效类型查询全国时效额外天数
	 * @param siteName
	 * @param agingType
	 * @return
	 */
	public AneBiSiteExtraDays findIsExit(String siteName,String agingType){
		return aneBiSiteExtraDaysRepository.findIsUnique(siteName, agingType);
	}
}
