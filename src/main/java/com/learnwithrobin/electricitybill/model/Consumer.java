package com.learnwithrobin.electricitybill.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="consumer")
public class Consumer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long consumerId;
	private String name;
	private String city;
	private String state;
	private long currentReading;
	private long previousReading;
	
	
	public Consumer() {
		
	}
	
	public Consumer(long consumerId, String name, String city, String state, long currentReading,
			long previousReading) {
		super();
		this.consumerId = consumerId;
		this.name = name;
		this.city = city;
		this.state = state;
		this.currentReading = currentReading;
		this.previousReading = previousReading;
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
	public long getPreviousReading() {
		return previousReading;
	}
	public void setPreviousReading(long previousReading) {
		this.previousReading = previousReading;
	}
	
	
}
