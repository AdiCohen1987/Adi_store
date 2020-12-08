package com.adi.persistence.gateways.interfaces;

import com.adi.persistence.model.Airline;

public interface AirlineRepositoryGateway {
    Airline getAirlineById(Long airlineId);

    Airline saveAirline(Airline airline);

    Iterable<Airline> findAll();
}
