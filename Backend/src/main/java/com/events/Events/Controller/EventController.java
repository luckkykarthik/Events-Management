package com.events.Events.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.events.Events.Service.eventService;
import com.events.Events.payload.inputDto;
import com.events.Events.payload.resultDto;


@RestController
@RequestMapping("/events")
@CrossOrigin("*")
public class EventController {
	
	@Autowired
	private eventService eS;

//	@GetMapping("/check")
//	public ResponseEntity<List<eventsDto>>  path() throws CsvValidationException{
////		try {
////            // Create a CSVReader object by passing a FileReader object and separator
////            CSVReader reader = new CSVReader(new FileReader("C:\\Users\\Karthik\\Desktop\\Events\\src\\main\\resources\\static\\data.csv"));
////
////            // Read CSV data line by line
////            String[] nextLine;
////            while ((nextLine = reader.readNext()) != null) {
////                // Process each line (array of values)
////                for (String value : nextLine) {
////                    System.out.print(value + " | ");
////                }
////                System.out.println(); // Move to the next line
////            }
////
////            // Close the reader
////            reader.close();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//		return new ResponseEntity<>(eS.addEvents(),HttpStatus.OK);
//	}
	@GetMapping("/find")
	public ResponseEntity<List<resultDto>>  findEvents(@RequestBody inputDto input){
		System.out.println(input.getDate());
		return new ResponseEntity<>(eS.findEvents(input),HttpStatus.OK);
		
	}
}
