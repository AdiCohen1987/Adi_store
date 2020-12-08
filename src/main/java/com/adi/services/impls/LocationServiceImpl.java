package com.adi.services.impls;

import com.adi.configuration.errorHandling.DBException;
import com.adi.persistence.AirlineRepositoryGateway;
import com.adi.persistence.model.AirlineLocations;
import com.adi.persistence.repo.AirlineLocationsRepository;
import com.adi.services.interfaces.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.adi.configuration.errorHandling.ErrorConstants.ERROR_RETRIEVING_FROM_DB;
import static com.adi.configuration.errorHandling.ErrorConstants.ERROR_SAVING_TO_DB;

@Service
public class LocationServiceImpl implements LocationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SellAircraftServiceImpl.class);

    @Autowired
    private AirlineRepositoryGateway airlineRepositoryGateway;

    @Autowired
    private AirlineLocationsRepository airlineLocationsRepository;

    @Override
    public AirlineLocations addLocation(AirlineLocations airlineLocation, Long airlineId) {
        airlineRepositoryGateway.getAirlineById(airlineId);
        AirlineLocations airlineLocationsRes;
        try {
            airlineLocationsRes = airlineLocationsRepository.save(airlineLocation);
        } catch (Exception e) {
            throw new DBException(ERROR_SAVING_TO_DB);
        }
        LOGGER.info("updated AirlineLocation: {}", airlineLocationsRes);
        return airlineLocationsRes;
    }


    @Override
    public List<AirlineLocations> getAllLocationsByAirline( Long airlineId) {
        List<AirlineLocations> airlineLocationsRes;
        try {
            airlineLocationsRes = airlineLocationsRepository.getDistinctByAirlineId(airlineId);
        } catch (Exception e) {
            throw new DBException(ERROR_RETRIEVING_FROM_DB);
        }
        LOGGER.info("updated AirlineLocation: {}", airlineLocationsRes);
        return airlineLocationsRes;
    }


}
