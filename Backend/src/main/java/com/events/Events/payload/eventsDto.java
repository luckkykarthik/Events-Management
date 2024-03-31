package com.events.Events.payload;

import java.time.LocalDate;
import java.time.LocalTime;


public class eventsDto {
	private String event_name;
	private String city_name;
	private LocalDate date;
	private LocalTime time;
	private double latitude;
	private double longitude;

	public eventsDto() {
		super();
	}

	public eventsDto(String event_name, String city_name, LocalDate date, LocalTime time, double latitude,
			double longitude) {
		super();
		this.event_name = event_name;
		this.city_name = city_name;
		this.date = date;
		this.time = time;
		this.latitude = latitude;
		this.longitude = longitude;
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
}
