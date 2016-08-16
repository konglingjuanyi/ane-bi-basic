package com.ane56.bi.domain.basics;

import com.ane56.bi.port.adapter.utils.IdUtils;

public class Schedulesstops {
	private String id;
	private String scheduleId;//班次计划id
	private String stopId;//经停地id
	
	public Schedulesstops() {
	}
	
	public Schedulesstops(String scheduleId, String stopId) {
		super();
		this.id = IdUtils.id4str();
		this.scheduleId = scheduleId;
		this.stopId = stopId;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}
	public String getStopId() {
		return stopId;
	}
	public void setStopId(String stopId) {
		this.stopId = stopId;
	}
}
