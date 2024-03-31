package com.events.Events.Service;

import java.time.LocalDate;
import java.util.Map;

public interface WeatherService {
	public Map<String,String> getWeatherData(String City,LocalDate date);
}
