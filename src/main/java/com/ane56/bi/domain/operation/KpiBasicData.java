package com.ane56.bi.domain.operation;
import java.util.Date;
import com.ane56.bi.domain.Entity;
public class KpiBasicData extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1941856654534408720L;
	private int kpiId;
	private String kpiName;
	private String kpiSimpleName;
	private int kpiType;
	private Date effectiveBeginTime;
	private Date effectiveEndTime;
	private Date createTime;
	private Date updateTime;
	private String createdName;
	private String updatedName;
	private int createdId;
	private int updatedId;
	private int status;
	public int getKpiId() {
		return kpiId;
	}
	public void setKpiId(int kpiId) {
		this.kpiId = kpiId;
	}
	public String getKpiName() {
		return kpiName;
	}
	public void setKpiName(String kpiName) {
		this.kpiName = kpiName;
	}
	public String getKpiSimpleName() {
		return kpiSimpleName;
	}
	public void setKpiSimpleName(String kpiSimpleName) {
		this.kpiSimpleName = kpiSimpleName;
	}
	public int getKpiType() {
		return kpiType;
	}
	public void setKpiType(int kpiType) {
		this.kpiType = kpiType;
	}
	public Date getEffectiveBeginTime() {
		return effectiveBeginTime;
	}
	public void setEffectiveBeginTime(Date effectiveBeginTime) {
		this.effectiveBeginTime = effectiveBeginTime;
	}
	public Date getEffectiveEndTime() {
		return effectiveEndTime;
	}
	public void setEffectiveEndTime(Date effectiveEndTime) {
		this.effectiveEndTime = effectiveEndTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getCreatedName() {
		return createdName;
	}
	public void setCreatedName(String createdName) {
		this.createdName = createdName;
	}
	public String getUpdatedName() {
		return updatedName;
	}
	public void setUpdatedName(String updatedName) {
		this.updatedName = updatedName;
	}
	public int getCreatedId() {
		return createdId;
	}
	public void setCreatedId(int createdId) {
		this.createdId = createdId;
	}
	public int getUpdatedId() {
		return updatedId;
	}
	public void setUpdatedId(int updatedId) {
		this.updatedId = updatedId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
