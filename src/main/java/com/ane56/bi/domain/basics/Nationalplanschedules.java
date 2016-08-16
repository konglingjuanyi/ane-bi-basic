package com.ane56.bi.domain.basics;

import java.sql.Time;

import com.ane56.bi.domain.Entity;
import com.ane56.bi.port.adapter.utils.IdUtils;

public class Nationalplanschedules{
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
	
	public Nationalplanschedules(){
	}
	
	public Nationalplanschedules(String routeName, String loadType,
			String vehicleType, String departPeriod, String departPlace,
			Time departTime, String destination, int arteryTime,
			Time arriveTime, String cargoRoute, String departPlaceId,
			String destinationId, String stopNames, int stopsNum) {
		super();
		this.id = IdUtils.id4str();
		this.routeName = routeName;
		this.loadType = loadType;
		this.vehicleType = vehicleType;
		this.departPeriod = departPeriod;
		this.departPlace = departPlace;
		this.departTime = departTime;
		this.destination = destination;
		this.arteryTime = arteryTime;
		this.arriveTime = arriveTime;
		this.cargoRoute = cargoRoute;
		this.departPlaceId = departPlaceId;
		this.destinationId = destinationId;
		this.stopNames = stopNames;
		this.stopsNum = stopsNum;
	}
	
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
	
}
