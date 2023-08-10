package com.gainitgyan.airlinewebservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gainitgyan.airlinewebservice.dto.FlightDto;
import com.gainitgyan.airlinewebservice.entity.Flight;
import com.gainitgyan.airlinewebservice.repository.IFlightRepository;


@Service
public class FlightService implements IFlightService {
	
	@Autowired
	IFlightRepository flightRepo;

	@Override
	public FlightDto createFlight(FlightDto flightDto) {
		
		Flight flight = new Flight();
		BeanUtils.copyProperties(flightDto, flight);
		flight = flightRepo.save(flight);
		BeanUtils.copyProperties(flight, flightDto);
		return flightDto;
	}
	@Override
	public  FlightDto getflight(Integer flightId) {
		// TODO Auto-generated method stub
		Optional<Flight> flight = flightRepo.findById(flightId);
		FlightDto dto = null;
		if(flight.isPresent()) {
			dto = new FlightDto();
			BeanUtils.copyProperties(flight.get(), dto);
		}
		return dto;
	}
	@Override
	public FlightDto updateFlight(FlightDto flightDto) {
		// TODO Auto-generated method stub
		Optional<Flight> flightOpt = flightRepo.findById(flightDto.getId());
		if(flightOpt.isPresent()) {
			Flight flight = new Flight();
			BeanUtils.copyProperties(flightDto, flight);
			flight = flightRepo.save(flight);
			BeanUtils.copyProperties(flight, flightDto);
		}
		else {
			//TO DO
			System.out.println("Exception updateFlight...");
		}
		return flightDto;
	}
	@Override
	public void deleteFlight(Integer flightId) {
		// TODO Auto-generated method stub
		Optional<Flight> flightOpt = flightRepo.findById(flightId);
		if(flightOpt.isPresent()) {
			flightRepo.deleteById(flightId);
		}
		else {
			//TO DO
			System.out.println("Exception deleteFlight...");
		}
	}
	@Override
	public List<FlightDto> getAllFlights() {
		// TODO Auto-generated method stub
		Iterable<Flight> iterable = flightRepo.findAll();
		
		List<FlightDto> flights = StreamSupport.stream(iterable.spliterator(), false).map(flight->{
			FlightDto dto = new FlightDto();
			BeanUtils.copyProperties(flight, dto);
			return dto;
		}).collect(Collectors.toList());
		return flights;
	}
	@Override
	public FlightDto getFlightByFlightNumber(String flightNumber) {
		// TODO Auto-generated method stub
		Flight flight = flightRepo.findByFlightNumber(flightNumber);
		FlightDto dto = new FlightDto();
		BeanUtils.copyProperties(flight, dto);
		return dto;
	}


}
