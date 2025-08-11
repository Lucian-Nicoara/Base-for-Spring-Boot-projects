package com.lucian.base.model;

import java.util.List;

public class TableData<T> {
	private int draw;
	private long recordsTotal;
	private long recordsFiltered;
	private List<T> data;
	
	public TableData(long recordsTotal, long recordsFiltered, List<T> data) {
		this.draw = 1;
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsFiltered;
		this.data = data;
	}

	public int getDraw() {
		return draw;
	}
	
	public void setDraw(int draw) {
		this.draw = draw;
	}
	
	public long getRecordsTotal() {
		return recordsTotal;
	}
	
	public void setRecordsTotal(long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	
	public long getRecordsFiltered() {
		return recordsFiltered;
	}
	
	public void setRecordsFiltered(long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
}