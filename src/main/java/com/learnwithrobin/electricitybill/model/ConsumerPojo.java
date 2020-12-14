package com.learnwithrobin.electricitybill.model;

public class ConsumerPojo {
	
	public long consumerId;
	private String name;
	private String city;
	private String state;
	private long currentReading;
	
	public ConsumerPojo() {
		
	}

	public ConsumerPojo(long consumerId, String name, String city, String state, long currentReading) {
		super();
		this.consumerId = consumerId;
		this.name = name;
		this.city = city;
		this.state = state;
		this.currentReading = currentReading;
	}

	public long getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(long consumerId) {
		this.consumerId = consumerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getCurrentReading() {
		return currentReading;
	}

	public void setCurrentReading(long currentReading) {
		this.currentReading = currentReading;
	}
	
	
}
