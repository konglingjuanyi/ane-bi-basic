package com.ane56.bi.common.pager;
import java.util.List;

public class Pagination<T> {

	private List<T> result;
	private int total;
	private int offset;
	private int limit;
	private int current;

	public Pagination() {
		super();
	}

	public Pagination(int current, int limit) {
		super();
		this.current = current;
		this.offset = (current - 1) * limit;
		this.limit = limit;
		
		if (this.offset < 0) {
			this.offset = 0;
		}
	}

	public Pagination(List<T> result, int total, int offset, int limit) {
		super();
		this.result = result;
		this.total = total;
		this.offset = offset;
		this.limit = limit;
		this.current = getCurrentPage();
	}

	public List<T> getResult() {
		return result;
	}

	public int getTotal() {
		return total;
	}

	public int getOffset() {
		return offset;
	}

	public int getLimit() {
		return limit;
	}

	public int getCurrentPage() {
		int current = offset / limit + 1;

		if (current <= 0) {
			current = 1;
		}

		if (offset % limit > total) {
			current = total / limit + 1;
		}
		return current;
	}

	public int getPageSize() {
		return this.limit;
	}

	public int getCurrent() {
		return current;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

}
