package com.adi.persistence.gateways.interfaces;

import com.adi.persistence.model.AirlineAircrafts;

import java.util.List;

public interface AircraftRepositoryGateway {

    AirlineAircrafts findById(Long aircraftId);

    List<AirlineAircrafts> getAirlineAircrafts(Long airlineId);

    AirlineAircrafts save(AirlineAircrafts updatedAircraft);
}
