package com.events.Events.payload;

import java.time.LocalDate;

public class inputDto {

	private double latitude;
	private double longitude;
	private LocalDate date;
	public inputDto() {
		super();
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
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}
