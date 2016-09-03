package com.ane56.bi.port.adapter.persistence;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ane56.bi.domain.radio.AneBiSiteRadioStandard;
import com.ane56.bi.domain.radio.AneBiSiteRadioStandardRepository;
import com.ane56.db.mybatis.query.QueryBuilder;
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
	public List<AneBiSiteRadioStandard> getRadio() {
		return this.repository().query(new QueryBuilder(AneBiSiteRadioStandard.class).build());
	}

	/**
	 * 创建比例标准
	 */
	public void createRadio(AneBiSiteRadioStandard entity) {
		this.repository().insert(entity);
	}

	/**
	 * 更新比例标准
	 */
	public void updateRadio(AneBiSiteRadioStandard entity) {
		this.repository().update(entity);
	}

}
