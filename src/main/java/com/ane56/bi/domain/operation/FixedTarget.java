package com.ane56.bi.domain.operation;
import java.util.Date;
import com.ane56.bi.domain.Entity;
public class FixedTarget extends Entity {
	private static final long serialVersionUID = 8098270767643875199L;
	private int fixedTargetId;
	private String fixedTargetName;
	private int showMark;
	private String showName;
	private String showType;
	private int targetOrder;
	private int moduleId;
	private int fixedMark;
	private int createdId;
	private String createdName;
	private Date createTime;
	private int updatedId;
	private String updatedName;
	private Date updateTime;
	private int status;
	public int getFixedTargetId() {
		return fixedTargetId;
	}
	public void setFixedTargetId(int fixedTargetId) {
		this.fixedTargetId = fixedTargetId;
	}
	public String getFixedTargetName() {
		return fixedTargetName;
	}
	public void setFixedTargetName(String fixedTargetName) {
		this.fixedTargetName = fixedTargetName;
	}
	public int getShowMark() {
		return showMark;
	}
	public void setShowMark(int showMark) {
		this.showMark = showMark;
	}
	public String getShowName() {
		return showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}
	public String getShowType() {
		return showType;
	}
	public void setShowType(String showType) {
		this.showType = showType;
	}
	public int getModuleId() {
		return moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	public int getFixedMark() {
		return fixedMark;
	}
	public void setFixedMark(int fixedMark) {
		this.fixedMark = fixedMark;
	}
	public int getCreatedId() {
		return createdId;
	}
	public void setCreatedId(int createdId) {
		this.createdId = createdId;
	}
	public String getCreatedName() {
		return createdName;
	}
	public void setCreatedName(String createdName) {
		this.createdName = createdName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getUpdatedId() {
		return updatedId;
	}
	public void setUpdatedId(int updatedId) {
		this.updatedId = updatedId;
	}
	public String getUpdatedName() {
		return updatedName;
	}
	public void setUpdatedName(String updatedName) {
		this.updatedName = updatedName;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getTargetOrder() {
		return targetOrder;
	}
	public void setTargetOrder(int targetOrder) {
		this.targetOrder = targetOrder;
	}
	
}
