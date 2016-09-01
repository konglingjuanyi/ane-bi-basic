package com.ane56.bi.common.pager;

import java.util.List;

/**
 * 分页Bean，它会在各层之间传递！
 * @author yangdechao
 *
 * @param <T>
 */
public class PageBean<T> {
	private int currentPage;//当前页码
	private int total;//总记录数
	private int pageSize;//每页记录数
	private String url;//请求路径和参数，例如：/BookServlet?method=findXXX&cid=1&bname=2
	private List<T> beanList;
	
	// 计算总页数
	public int getTotalPageNum() {
		int tp = total / pageSize;
		return total % pageSize == 0 ? tp : tp + 1;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<T> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
	
	
}
