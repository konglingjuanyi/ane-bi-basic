package com.ane56.bi.domain.basics;

import java.sql.Time;

import com.ane56.bi.port.adapter.utils.IdUtils;

public class Stops {
	private String id;
	private String stopName;//经停地
	private int stopSort;//经停地顺序
	private int arteryTime;//干线时效
	private Time arriveTime;//规定到达时间
	private int intervalTime;//中转间隔时间
	private Time leaveTime;//规定离开时间
	private String stopId;//经停地id
	
	public Stops(){
	}
	
	public Stops(String stopName, int stopSort, int arteryTime,
			Time arriveTime, int intervalTime, Time leaveTime,
			String stopId) {
		super();
		this.id = IdUtils.id4str();
		this.stopName = stopName;
		this.stopSort = stopSort;
		this.arteryTime = arteryTime;
		this.arriveTime = arriveTime;
		this.intervalTime = intervalTime;
		this.leaveTime = leaveTime;
		this.stopId = stopId;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStopName() {
		return stopName;
	}
	public void setStopName(String stopName) {
		this.stopName = stopName;
	}
	public int getStopSort() {
		return stopSort;
	}
	public void setStopSort(int stopSort) {
		this.stopSort = stopSort;
	}
	public int getArteryTime() {
		return arteryTime;
	}
	public void setArteryTime(int arteryTime) {
		this.arteryTime = arteryTime;
	}
	public Time getArriveTime() {
		return arriveTime;
	}
	public void setArriveTime(Time arriveTime) {
		this.arriveTime = arriveTime;
	}
	public int getIntervalTime() {
		return intervalTime;
	}
	public void setIntervalTime(int intervalTime) {
		this.intervalTime = intervalTime;
	}
	public Time getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(Time leaveTime) {
		this.leaveTime = leaveTime;
	}
	public String getStopId() {
		return stopId;
	}
	public void setStopId(String stopId) {
		this.stopId = stopId;
	}
	
}
