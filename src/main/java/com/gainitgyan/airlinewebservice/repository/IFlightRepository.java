package com.gainitgyan.airlinewebservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gainitgyan.airlinewebservice.entity.Flight;
import java.util.List;


@Repository
public interface IFlightRepository extends CrudRepository<Flight, Integer>{
	
	Flight findByFlightNumber(String flightNumber);

}
