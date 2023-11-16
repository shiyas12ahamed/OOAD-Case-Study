package com.ilp.entity;

public class Services {
	private String serviceCode;
	private String serviceName;
	private double servicePrice;
	public Services(String serviceCode, String serviceName, double servicePrice) {
		this.serviceCode = serviceCode;
		this.serviceName = serviceName;
		this.servicePrice = servicePrice;
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public double getServicePrice() {
		return servicePrice;
	}
	public void setServicePrice(double servicePrice) {
		this.servicePrice = servicePrice;
	}
}
