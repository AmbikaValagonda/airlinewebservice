package com.gainitgyan.airlinewebservice.service;

import java.util.List;

import com.gainitgyan.airlinewebservice.dto.FlightDto;
import com.gainitgyan.airlinewebservice.entity.Flight;

public interface IFlightService {

		public FlightDto createFlight(FlightDto flightDto);

		public FlightDto getflight(Integer flightId);

		public FlightDto updateFlight(FlightDto flightDto);

		public void deleteFlight(Integer flightId);

		public List<FlightDto> getAllFlights();

		public FlightDto getFlightByFlightNumber(String flightNumber);
}
