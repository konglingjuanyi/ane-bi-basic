package com.ane56.bi.domain.radio;

import java.util.List;

/**
 * 类描述:承接网点比例标准接口类
 * @author zhangyibo
 *
 */
public interface AneBiSiteRadioStandardRepository {
	/**
	 * 获取比例标准
	 * @return
	 */
	List<AneBiSiteRadioStandard> getRadio();
	/**
	 * 创建比例标准
	 * @param entity
	 */
	void createRadio(AneBiSiteRadioStandard entity);
	/**
	 * 更新比例标准
	 * @param entity
	 */
	void updateRadio(AneBiSiteRadioStandard entity);
}
