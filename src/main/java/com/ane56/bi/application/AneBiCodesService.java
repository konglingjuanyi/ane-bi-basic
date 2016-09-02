package com.ane56.bi.application;

import java.util.Date;
import java.util.List;

import com.ane56.bi.domain.basic.AneBiCodes;
import com.ane56.bi.domain.basic.AneBiCodesRepository;
import com.ane56.bi.port.adapter.utils.IdUtils;

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
	 * 分页查询字典项
	 * @param start
	 * @param limit
	 * @return
	 */
	public Pagination<AneBiCodes> getCodesWithPage(int start,int limit,String codeType,String description,String codeName) {
		return aneBiCodesRepository.getCodesWithPage(start, limit,codeType,description,codeName);
	}
	/**
	 * 根据编码类型和编码名称查询对应字典项
	 * @param codeType
	 * @param codeName
	 * @return
	 */
	public AneBiCodes findCodeByTypeAndValue(String codeType,String codeName){
		return aneBiCodesRepository.findCodeByTypeAndValue(codeType, codeName);
	}
	/**
	 * 新增字典项
	 * @param aneBiCodes
	 */
	public void addCode(AneBiCodes aneBiCodes){
		aneBiCodes.setId(IdUtils.id());
		aneBiCodes.setCreateTime(new Date());
		aneBiCodes.setUpdateTime(new Date());
		aneBiCodesRepository.addCode(aneBiCodes);
	}
	/**
	 * 更新字典项
	 * @param aneBiCodes
	 */
	public void updateCode(AneBiCodes aneBiCodes){
		AneBiCodes entity = aneBiCodesRepository.findById(aneBiCodes.getId());
		entity.update(aneBiCodes.getCodeType(), aneBiCodes.getDescription(), aneBiCodes.getCodeName());
		aneBiCodesRepository.updateCode(entity);
	}
	/**
	 * 删除字典项
	 * @param aneBiCodes
	 */
	public void deleteCode(AneBiCodes aneBiCodes){
		aneBiCodesRepository.deleteCode(aneBiCodes);
	}
	/**
	 * 根据id查询字典项
	 * @param id
	 * @return
	 */
	public AneBiCodes findById(long id){
		return aneBiCodesRepository.findById(id);
	}
}
