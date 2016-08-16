package com.ane56.bi.domain.basics;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.ane56.bi.port.adapter.utils.TimeFormatUtils;

/**
 *全国计划班次表vo
 * @author zhangyibo
 *
 */
public class PlanSchedulesVO {
	private String id;
	private String routeName;//班线名称
	private String loadType;//装卸类型
	private String vehicleType;//车型
	private String departPeriod;//发车周期
	private String departPlace;//始发地
	private Time departTime;//始发时间
	private String destination;//目的地
	private int arteryTime;//干线时效
	private Time arriveTime;//到达时间
	private String cargoRoute;//货物路线
	private String departPlaceId;//始发地id
	private String destinationId;//目的地id
	private String stopNames;//经停地名称
	private int stopsNum;//经停地数目
	
	private List<StopsVO> stopsVO;//经停地
	private String arteryTimeStr;//干线时效Str
	private String departTimeStr;//始发时间str
	private String arriveTimeStr;//到达时间str
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public String getLoadType() {
		return loadType;
	}
	public void setLoadType(String loadType) {
		this.loadType = loadType;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getDepartPeriod() {
		return departPeriod;
	}
	public void setDepartPeriod(String departPeriod) {
		this.departPeriod = departPeriod;
	}
	public String getDepartPlace() {
		return departPlace;
	}
	public void setDepartPlace(String departPlace) {
		this.departPlace = departPlace;
	}
	public Time getDepartTime() {
		return departTime;
	}
	public void setDepartTime(Time departTime) {
		this.departTime = departTime;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
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
	public String getCargoRoute() {
		return cargoRoute;
	}
	public void setCargoRoute(String cargoRoute) {
		this.cargoRoute = cargoRoute;
	}
//	public List<Stops> getStops() {
//		return stops;
//	}
//	public void setStops(List<Stops> stops) {
//		this.stops = stops;
//	}
	public String getDepartPlaceId() {
		return departPlaceId;
	}
	public void setDepartPlaceId(String departPlaceId) {
		this.departPlaceId = departPlaceId;
	}
	public String getDestinationId() {
		return destinationId;
	}
	public void setDestinationId(String destinationId) {
		this.destinationId = destinationId;
	}
	public String getStopNames() {
		return stopNames;
	}
	public void setStopNames(String stopNames) {
		this.stopNames = stopNames;
	}
	public int getStopsNum() {
		return stopsNum;
	}
	public void setStopsNum(int stopsNum) {
		this.stopsNum = stopsNum;
	}
	public List<StopsVO> getStopsVO() {
		return stopsVO;
	}
	public void setStopsVO(List<StopsVO> stopsVO) {
		this.stopsVO = stopsVO;
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
	public String getDepartTimeStr() {
		return departTimeStr;
	}
	public void setDepartTimeStr(String departTimeStr) {
		this.departTimeStr = departTimeStr;
	}
	public void setDepartTimeStr() {
		String str = departTime + "";
		str = str.substring(0, str.length()-3);
		this.departTimeStr = str;
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
	
}
