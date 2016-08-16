package com.ane56.bi.domain.basics;

import java.sql.Time;

import org.apache.commons.lang3.StringUtils;

import com.ane56.bi.port.adapter.utils.IdUtils;
import com.ane56.bi.port.adapter.utils.TimeFormatUtils;

public class StopsVO {
	private String id;
	private String stopName;//经停地
	private int stopSort;//经停地顺序
	private int arteryTime;//干线时效
	private Time arriveTime;//规定到达时间
	private int intervalTime;//中转间隔时间
	private Time leaveTime;//规定离开时间
	private String stopId;//经停地id
	
	private String arteryTimeStr;//干线时效Str
	private String intervalTimeStr;//间隔时效Str
	private String arriveTimeStr;//规定到达时间Str
	private String leaveTimeStr;//规定离开时间Str
	
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
	
	public String getArteryTimeStr() {
		String str = "";
		str = TimeFormatUtils.mescFormatToHours(arteryTime);
		return str;
	}
	public void setArteryTimeStr(String arteryTimeStr) {
		this.arteryTimeStr = arteryTimeStr;
	}
	public void setArteryTimeStr() {
		this.arteryTimeStr = TimeFormatUtils.mescFormatToHours(arteryTime);
	}
	public String getIntervalTimeStr() {
		String str = "";
		str = TimeFormatUtils.mescFormatToHours(intervalTime);
		return str;
	}
	public void setIntervalTimeStr(String intervalTimeStr) {
		this.intervalTimeStr = intervalTimeStr;
	}
	public void setIntervalTimeStr() {
		this.intervalTimeStr = TimeFormatUtils.mescFormatToHours(intervalTime);
	}
	public String getArriveTimeStr() {
		return arriveTimeStr;
	}
	public void setArriveTimeStr(String arriveTimeStr) {
		this.arriveTimeStr = arriveTimeStr;
	}
	public void setArriveTimeStr() {
		String str = arriveTime + "";
		str = str.substring(0, str.length()-3);
		this.arriveTimeStr = str;
	}
	public String getLeaveTimeStr() {
		return leaveTimeStr;
	}
	public void setLeaveTimeStr(String leaveTimeStr) {
		this.leaveTimeStr = leaveTimeStr;
	}
	public void setLeaveTimeStr() {
		String str = leaveTime + "";
		str = str.substring(0, str.length()-3);
		this.leaveTimeStr = str;
	}
	
}
