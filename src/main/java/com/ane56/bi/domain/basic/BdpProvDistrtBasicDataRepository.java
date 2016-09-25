package com.ane56.bi.domain.basic;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ane56.db.mybatis.core.Pagination;

/**
 * 
 * @author 张一波
 *
 */
public interface BdpProvDistrtBasicDataRepository {
	/**
	 * 查询所有区域
	 * @return
	 * @throws SQLException
	 */
	public List<BdpProvDistrtBasicDataVO> getAreaAll();
	/**
	 * 查询所有省区
	 * @return
	 * @throws SQLException
	 */
	public List<BdpProvDistrtBasicDataVO> getProvinceAll();
	/**
	 * 分页查询省区
	 * @param paramObject
	 * @param offset
	 * @param limit
	 * @return
	 */
	public Pagination<BdpProvDistrtBasicDataVO> getProveWithPage(Map<String,Object> paramObject,int offset, int limit);
	/**
	 * 分页查询大区
	 * @param paramObject
	 * @param offset
	 * @param limit
	 * @return
	 */
	public Pagination<BdpProvDistrtBasicDataVO> getDictrtWithPage(Map<String,Object> paramObject,int offset, int limit);
	/**
	 * 查询单条数据
	 * @param entity
	 * @return
	 */
	public BdpProvDistrtBasicData findOne(BdpProvDistrtBasicData entity);
	/**
	 * 更新省区/大区
	 * @param entity
	 * @return
	 */
	public int updateProvDistrt(BdpProvDistrtBasicData entity);
	/**
	 * （逻辑）删除省区/大区
	 * @param entity
	 * @return
	 */
	public int deleteProvDistrt(BdpProvDistrtBasicData entity);
	/**
	 * 新增省区/大区
	 * @param entity
	 * @return
	 */
	public int addProvDistrt(BdpProvDistrtBasicData entity);
	
}
