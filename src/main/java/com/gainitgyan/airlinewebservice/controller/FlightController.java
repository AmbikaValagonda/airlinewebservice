package com.gainitgyan.airlinewebservice.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.gainitgyan.airlinewebservice.dto.FlightDto;
import com.gainitgyan.airlinewebservice.entity.Flight;
import com.gainitgyan.airlinewebservice.repository.IFlightRepository;
import com.gainitgyan.airlinewebservice.service.FlightService;
import com.gainitgyan.airlinewebservice.service.IFlightService;

@RestController
public class FlightController {
	

	
	@Autowired
	IFlightService flightService;
	
	//Http GET method - Read operation
	@GetMapping(path = "/flight/{id}")
	public FlightDto getFlight(@PathVariable(name = "id") Integer flightId) {
		return flightService.getflight(flightId);
	}
	
	//Http GET method - Read operation
	@GetMapping(path = "/flight")
	public List<FlightDto> getAllFlights() {
		return flightService.getAllFlights();
	}
	
	//Http GET method - Read operation
	@GetMapping(path = "/flight/flightData/{flightNumber}")
	public FlightDto getFlightByFlightNumber(@PathVariable(name="flightNumber") String flightNumber) {
		return flightService.getFlightByFlightNumber(flightNumber);
	}
	
	@PostMapping(path = "/flight")
	//Http POST method - Create operation
	public FlightDto createFlight(@RequestBody FlightDto flightDto) {
		
		return  flightService.createFlight(flightDto);
	}
	
	@PutMapping(path = "/flight")
	//Http PUT method - Update operation
	public FlightDto updateFlight(@RequestBody FlightDto flightDto) {
		return flightService.updateFlight(flightDto);
	}

	@DeleteMapping(path = "/flight/delete/{id}")
	//Http DELETE method - Delete operation
	public void deleteFlight(@PathVariable(name = "id") Integer flightId) {
		flightService.deleteFlight(flightId);
	}


}
