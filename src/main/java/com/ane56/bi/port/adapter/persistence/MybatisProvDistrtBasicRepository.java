package com.ane56.bi.port.adapter.persistence;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ane56.bi.domain.basic.BdpProvDistrtBasicData;
import com.ane56.bi.domain.basic.BdpProvDistrtBasicDataRepository;
import com.ane56.bi.domain.basic.BdpProvDistrtBasicDataVO;
import com.ane56.db.mybatis.core.Pagination;

/**
 * 
 * @author 张一波
 *
 */
@Component
public class MybatisProvDistrtBasicRepository extends SpringMybatisRepositorySupport implements BdpProvDistrtBasicDataRepository{

	/**
	 * 查询所有区域
	 * @return
	 * @throws SQLException
	 */
	public List<BdpProvDistrtBasicDataVO> getAreaAll() {
		List<BdpProvDistrtBasicDataVO> list = this.repository().query("Bdp_ProvDistrt.queryAreaList");
		return list;
	}
	/**
	 * 查询所有运营省区
	 */
	public List<BdpProvDistrtBasicDataVO> getProvinceAll() {
		List<BdpProvDistrtBasicDataVO> list = this.repository().query("Bdp_ProvDistrt.queryProvinceList");
		return list;
	}
	/**
	 * 分页查询运营省区
	 */
	public Pagination<BdpProvDistrtBasicDataVO> getProveWithPage(
			Map<String, Object> paramObject, int offset, int limit) {
		Pagination<BdpProvDistrtBasicDataVO> pageData = this.queryWithPage("Bdp_Province", paramObject, offset, limit);
		return pageData;
	}
	/**
	 * 分页查询大区
	 */
	public Pagination<BdpProvDistrtBasicDataVO> getDictrtWithPage(
			Map<String, Object> paramObject, int offset, int limit) {
		Pagination<BdpProvDistrtBasicDataVO> pageData = this.queryWithPage("Bdp_ProvDistrt", paramObject, offset, limit);
		return pageData;
	}
	/**
	 * 根据主键查询一条数据
	 */
	public BdpProvDistrtBasicData findOne(BdpProvDistrtBasicData entity) {
		BdpProvDistrtBasicData result = (BdpProvDistrtBasicData) this.repository().queryBy("Bdp_ProvDistrt.findById", entity);
		return result;
	}
	/**
	 * 更新数据
	 */
	public int updateProvDistrt(BdpProvDistrtBasicData entity) {
		int result = this.repository().update("Bdp_ProvDistrt.update", entity);
		return result;
	}
	/**
	 * (逻辑)删除数据
	 */
	public int deleteProvDistrt(BdpProvDistrtBasicData entity) {
		int result = this.repository().update("Bdp_ProvDistrt.delete", entity);
		return result;
	}
	/**
	 * 新增数据
	 */
	public int addProvDistrt(BdpProvDistrtBasicData entity) {
		int result = this.repository().update("Bdp_ProvDistrt.add", entity);
		return result;
	}
	
}
