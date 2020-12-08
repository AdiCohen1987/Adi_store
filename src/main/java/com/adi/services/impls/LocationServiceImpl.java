package com.adi.services.impls;

import com.adi.persistence.gateway.interfaces.AirlineRepositoryGateway;
import com.adi.persistence.gateway.interfaces.LocationRepositoryGateway;
import com.adi.persistence.model.AirlineLocations;
import com.adi.services.interfaces.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SellAircraftServiceImpl.class);

    @Autowired
    private AirlineRepositoryGateway airlineRepositoryGateway;

    @Autowired
    private LocationRepositoryGateway locationRepositoryGateway;

    @Override
    public AirlineLocations addLocation(AirlineLocations airlineLocation, Long airlineId) {
        airlineRepositoryGateway.getAirlineById(airlineId);
        return locationRepositoryGateway.save(airlineLocation);
    }


    @Override
    public List<AirlineLocations> getAllLocationsByAirline(Long airlineId) {
        return locationRepositoryGateway.getDistinctByAirlineId(airlineId);
    }


}
