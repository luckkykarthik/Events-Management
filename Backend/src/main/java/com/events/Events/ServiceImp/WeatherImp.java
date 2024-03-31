package com.events.Events.ServiceImp;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.events.Events.Exception.InternetNotConnected;
import com.events.Events.Service.WeatherService;

@Service
public class WeatherImp implements WeatherService{


	@Override
	public Map<String, String> getWeatherData(String City, LocalDate date) {
		try {
			String baseUrl = "https://gg-backend-assignment.azurewebsites.net/api/Weather?code=KfQnTWHJbg1giyB_Q9Ih3Xu3L9QOBDTuU5zwqVikZepCAzFut3rqsg==&city=";
			String dateString = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			String encodedCity = URLEncoder.encode(City, StandardCharsets.UTF_8);
			String apiUrl = baseUrl + encodedCity + "&date=" + dateString;
			RestTemplate restTemplate = new RestTemplate();
			Map<String, String> weatherMap = restTemplate.getForObject(apiUrl, Map.class);
			return weatherMap;
		}catch(Exception e) {
			throw new InternetNotConnected("No Internet/data not parsed coreectly");
		}
	}

}
