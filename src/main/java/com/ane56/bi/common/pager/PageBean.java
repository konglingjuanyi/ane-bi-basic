package com.ane56.bi.common.pager;

import java.util.List;

/**
 * 分页Bean，它会在各层之间传递！
 * @author yangdechao
 *
 * @param <T>
 */
public class PageBean<T> {
	private int current;//当前页码
	private int total;//总记录数
	private int offset;
	private int pageSize;//每页记录数
	private List<T> beanList;
	
	// 计算总页数
	public int getTotalPageNum() {
		int tp = total / pageSize;
		return total % pageSize == 0 ? tp : tp + 1;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	
}
