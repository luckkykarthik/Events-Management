package com.events.Events.Service;

import java.util.List;

import com.events.Events.payload.eventsDto;
import com.events.Events.payload.inputDto;
import com.events.Events.payload.resultDto;

public interface eventService {
	public List<eventsDto> getAllEvents();
	public List<eventsDto> addEvents();
	public List<resultDto> findEvents(inputDto input);
}
