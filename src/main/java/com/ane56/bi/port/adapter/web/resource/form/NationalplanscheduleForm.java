package com.ane56.bi.port.adapter.web.resource.form;

public class NationalplanscheduleForm {
	private String departPlace;//始发地
	private String destination;//目的地
	private String departPeriod;//发车周期
	private String vehicleType;//车型
	private String loadType;//装卸类型
	private String stopNames;//经停地
	
	public String getDepartPlace() {
		return departPlace;
	}
	public void setDepartPlace(String departPlace) {
		this.departPlace = departPlace;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDepartPeriod() {
		return departPeriod;
	}
	public void setDepartPeriod(String departPeriod) {
		this.departPeriod = departPeriod;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getLoadType() {
		return loadType;
	}
	public void setLoadType(String loadType) {
		this.loadType = loadType;
	}
	public String getStopNames() {
		return stopNames;
	}
	public void setStopNames(String stopNames) {
		this.stopNames = stopNames;
	}
	
}
