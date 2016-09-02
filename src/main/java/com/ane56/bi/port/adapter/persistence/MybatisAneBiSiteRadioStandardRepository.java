package com.ane56.bi.port.adapter.persistence;

import java.util.List;

import com.ane56.bi.domain.radio.AneBiSiteRadioStandard;
import com.ane56.bi.domain.radio.AneBiSiteRadioStandardRepository;
/**
 * 类描述：承接网点比例标准实现类
 * @author zhangyibo
 *
 */
@Component
public class MybatisAneBiSiteRadioStandardRepository extends SpringMybatisRepositorySupport implements AneBiSiteRadioStandardRepository{

	/**
	 * 获取比例标准
	 */
	@Override
	public List<AneBiSiteRadioStandard> getRadio() {
		return this.repository().query(new QueryBuilder(AneBiSiteRadioStandard.class).build());
	}

	/**
	 * 创建比例标准
	 */
	@Override
	public void createRadio(AneBiSiteRadioStandard entity) {
		this.repository().insert(entity);
	}

	/**
	 * 更新比例标准
	 */
	@Override
	public void updateRadio(AneBiSiteRadioStandard entity) {
		this.repository().update(entity);
	}

}
