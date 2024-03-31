package com.events.Events.payload;

import java.time.LocalDate;

public class resultDto {
	private String event_name;
	private String city_name;
	private LocalDate date;
	private String weather;
	private double distance;
	public resultDto() {
		super();
	}
	public resultDto(String event_name, String city_name, LocalDate date, String weather, double distance) {
		super();
		this.event_name = event_name;
		this.city_name = city_name;
		this.date = date;
		this.weather = weather;
		this.distance = distance;
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
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
}
