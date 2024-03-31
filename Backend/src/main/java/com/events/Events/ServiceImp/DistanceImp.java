package com.events.Events.ServiceImp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.events.Events.Exception.DataNotParsedCorrectly;
import com.events.Events.Service.DistanceService;

@Service
public class DistanceImp implements DistanceService{

	@Override
	public Map<String, Double> CalaculateDistance(double latitude1, double longitude1, double latitude2, double longitude2) {
		String baseUrl = "https://gg-backend-assignment.azurewebsites.net/api/Distance?code=IAKvV2EvJa6Z6dEIUqqd7yGAu7IZ8gaH-a0QO6btjRc1AzFu8Y3IcQ==&latitude1=";
        String apiUrl = baseUrl + latitude1 + "&longitude1=" + longitude1 + "&latitude2=" + latitude2 + "&longitude2="
                + longitude2;
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("checked1");
        try {
        	Map<String, String> distanceMap = restTemplate.getForObject(apiUrl, Map.class);
        	Map<String,Double> distance=new HashMap<>();
            if (distanceMap != null && distanceMap.containsKey("distance")) {
            	
                Double distanceStr = Double.parseDouble(distanceMap.get("distance"));
                //System.out.println(distanceStr);
                distance.put("distance", distanceStr);
                return distance;
            } else {
            	return null;
            }
        }catch(Exception e) {
        	System.out.println("checked2");
            throw new DataNotParsedCorrectly("Data correctly not parsed/No internet"); 
        }
        // The API should return a single value representing the distance
        
	}

}
