package com.adi.persistence.gateway.impl;

import com.adi.configuration.errorHandling.DBException;
import com.adi.configuration.errorHandling.EntityNotFoundException;
import com.adi.persistence.gateway.interfaces.AirlineRepositoryGateway;
import com.adi.persistence.model.Airline;
import com.adi.persistence.repo.AirlineAircarftsRepository;
import com.adi.persistence.repo.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.adi.configuration.errorHandling.ErrorConstants.ERROR_RETRIEVING_FROM_DB;
import static com.adi.configuration.errorHandling.ErrorConstants.ERROR_SAVING_TO_DB;

@Service
public class AirlineRepositoryGatewayImpl implements AirlineRepositoryGateway {

    @Autowired
    private AirlineRepository airlineRepository;

    @Override
    public Airline getAirlineById(Long airlineId) {
        Optional<Airline> airline;
        try {
            airline = airlineRepository.findById(airlineId);
            if (airline.isPresent()) {
                throw new EntityNotFoundException("Airline with id: " + airlineId + "not found");
            }
        } catch (Exception e) {
            throw new DBException(ERROR_RETRIEVING_FROM_DB+ " " + e.getLocalizedMessage());
        }
        return airline.get();
    }

    @Override
    public Airline saveAirline(Airline airline) {
        Airline res;
        try {
            res = airlineRepository.save(airline);
        } catch (Exception e) {
            throw new DBException(ERROR_SAVING_TO_DB+ " " + e.getLocalizedMessage());
        }
        return res;
    }

    @Override
    public Iterable<Airline> findAll() {
        Iterable<Airline> airlineIterable;
        try {
            airlineIterable = airlineRepository.findAll();
        } catch (Exception e) {
            throw new DBException(ERROR_RETRIEVING_FROM_DB+ " " + e.getLocalizedMessage());
        }
        return airlineIterable;
    }
}
