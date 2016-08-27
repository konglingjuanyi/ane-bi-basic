package com.ane56.bi.g7.domain;


import java.util.List;

import com.ane56.bi.g7.domain.Classline;

public class PageResult {
	private int pageNo;
	private boolean autoCount;
	private int pageSize;
	private String pk;
	private String totalCount;
	private List<Classline> result;
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public boolean isAutoCount() {
		return autoCount;
	}
	public void setAutoCount(boolean autoCount) {
		this.autoCount = autoCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getPk() {
		return pk;
	}
	public void setPk(String pk) {
		this.pk = pk;
	}
	public String getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	public List<Classline> getResult() {
		return result;
	}
	public void setResult(List<Classline> result) {
		this.result = result;
	}
}
