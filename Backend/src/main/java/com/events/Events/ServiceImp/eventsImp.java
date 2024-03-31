package com.events.Events.ServiceImp;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.events.Events.Repositories.eventRepo;
import com.events.Events.Service.DistanceService;
import com.events.Events.Service.WeatherService;
import com.events.Events.Service.eventService;
import com.events.Events.model.events;
import com.events.Events.payload.eventsDto;
import com.events.Events.payload.inputDto;
import com.events.Events.payload.resultDto;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

@Service
public class eventsImp implements eventService {
    
    @Autowired
    private eventRepo ep;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private WeatherService ws;
    
    @Autowired
    private DistanceService ds;
    
    
    List<resultDto> lrd=new ArrayList<>();
    
    Map<String,String> weath;
    Map<String,Double> dist;

    @Override
    public List<eventsDto> getAllEvents() {
        List<events> Events = ep.findAll();
        return Events.stream().map(event -> modelMapper.map(event, eventsDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<eventsDto> addEvents() {
        List<eventsDto> eventDtos = new ArrayList<>();
        eventsDto ed = new eventsDto();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Create a DateTimeFormatterBuilder to handle both single and double-digit hours
        DateTimeFormatter timeFormatter = new DateTimeFormatterBuilder()
                                            .appendPattern("[H:mm:ss]")
                                            .toFormatter();
        
        try (CSVReader reader = new CSVReader(new FileReader("C:\\Users\\Karthik\\Desktop\\Events\\src\\main\\resources\\static\\data.csv"))) {
            reader.readNext(); // Skip the header line
            
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                ed.setEvent_name(nextLine[0]);
                ed.setCity_name(nextLine[1]);

                LocalDate date = LocalDate.parse(nextLine[2], dateFormatter);
                LocalTime time = LocalTime.parse(nextLine[3], timeFormatter); // Use the custom time formatter
                ed.setDate(date);
                ed.setTime(time);

                ed.setLatitude(Double.parseDouble(nextLine[4]));
                ed.setLongitude(Double.parseDouble(nextLine[5]));
                ep.save(modelMapper.map(ed, events.class));
                eventDtos.add(ed);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        
        return eventDtos;
    }

	@Override
	public List<resultDto> findEvents(inputDto input) {
		List<events> Events =ep.findByDateBetweenOrderByDateAsc(input.getDate(),input.getDate().plusDays(14));
		for(events k:Events) {
			resultDto rd=new resultDto();
			weath=ws.getWeatherData(k.getCity_name(), k.getDate());
			dist=ds.CalaculateDistance(input.getLatitude(), input.getLongitude(), k.getLatitude(), k.getLongitude());
//			System.out.println(weath);
//			System.out.println(dist);
			rd.setEvent_name(k.getEvent_name());
			rd.setCity_name(k.getCity_name());
			rd.setDate(k.getDate());
			rd.setWeather(weath.get("weather"));
			rd.setDistance(dist.get("distance"));
			lrd.add(rd);
			 
		}
		return lrd;
//		return Events.stream().map(event -> modelMapper.map(event, eventsDto.class)).collect(Collectors.toList());
	}
}
