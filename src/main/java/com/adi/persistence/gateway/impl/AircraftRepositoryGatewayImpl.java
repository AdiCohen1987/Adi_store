package com.adi.persistence.gateway.impl;

import com.adi.configuration.errorHandling.DBException;
import com.adi.configuration.errorHandling.EntityNotFoundException;
import com.adi.persistence.gateway.interfaces.AircraftRepositoryGateway;
import com.adi.persistence.model.AirlineAircrafts;
import com.adi.persistence.repo.AirlineAircarftsRepository;
import com.adi.services.impls.SellAircraftServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.adi.configuration.errorHandling.ErrorConstants.ERROR_RETRIEVING_FROM_DB;
import static com.adi.configuration.errorHandling.ErrorConstants.ERROR_SAVING_TO_DB;

@Service
public class AircraftRepositoryGatewayImpl implements AircraftRepositoryGateway {

    private static final Logger LOGGER = LoggerFactory.getLogger(SellAircraftServiceImpl.class);

    @Autowired
    private AirlineAircarftsRepository airlineAircarftsRepository;


    @Override
    public AirlineAircrafts findById(Long aircraftId) {
        Optional<AirlineAircrafts> optionalAirlineAircraft;
        try {
            optionalAirlineAircraft = airlineAircarftsRepository.findById(aircraftId);
            if (optionalAirlineAircraft.isPresent()) {
                throw new EntityNotFoundException("Aircraft with id: " + aircraftId + "not found");
            }
        } catch (Exception e) {
            throw new DBException(ERROR_RETRIEVING_FROM_DB + " " + e.getLocalizedMessage());
        }
        return optionalAirlineAircraft.get();
    }

    @Override
    public AirlineAircrafts save(AirlineAircrafts updatedAircraft) {
        AirlineAircrafts result;
        try {
            result = airlineAircarftsRepository.save(updatedAircraft);
        } catch (Exception e) {
            throw new DBException(ERROR_SAVING_TO_DB + " " + e.getLocalizedMessage());
        }
        LOGGER.info("updated aircarft: {}", result);
        return result;
    }
}
