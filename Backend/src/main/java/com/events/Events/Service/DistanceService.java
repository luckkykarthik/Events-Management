package com.events.Events.Service;

import java.util.Map;

public interface DistanceService {
	public Map<String, Double> CalaculateDistance(double latitude1,double longitude1,double latitude2,double longitude2);
}
