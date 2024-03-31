package com.events.Events.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class events {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	@Column(nullable=false)
	private String event_name;
	
	@Column(nullable=false)
	private String city_name;
	
	@Column(nullable=false)
	private  LocalDate date;
	
	@Column(nullable=false)
	private LocalTime time;
	
	@Column(nullable=false)
	private double latitude;
	
	@Column(nullable=false)
	private double longitude;

	public events() {
		super();
	}

	public events(long id, String event_name, String city_name, LocalDate date, LocalTime time, double latitude,
			double longitude) {
		super();
		this.id = id;
		this.event_name = event_name;
		this.city_name = city_name;
		this.date = date;
		this.time = time;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "events [id=" + id + ", event_name=" + event_name + ", city_name=" + city_name + ", date=" + date
				+ ", time=" + time + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	
	
}
