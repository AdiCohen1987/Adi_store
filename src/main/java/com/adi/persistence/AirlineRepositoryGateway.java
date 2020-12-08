package com.adi.persistence;

import com.adi.configuration.errorHandling.DBException;
import com.adi.configuration.errorHandling.EntityNotFoundException;
import com.adi.persistence.model.Airline;
import com.adi.persistence.repo.AirlineAircarftsRepository;
import com.adi.persistence.repo.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.adi.configuration.errorHandling.ErrorConstants.ERROR_RETRIEVING_FROM_DB;
import static com.adi.configuration.errorHandling.ErrorConstants.ERROR_SAVING_TO_DB;

@Service
public class AirlineRepositoryGateway {

    @Autowired
    private AirlineRepository airlineRepository;

    public Airline getAirlineById(Long airlineId) {
        Optional<Airline> airline;
        try {
            airline = airlineRepository.findById(airlineId);
            if (airline.isPresent()) {
                throw new EntityNotFoundException("Airline with id: " + airlineId + "not found");
            }
        } catch (Exception e) {
            throw new DBException(ERROR_RETRIEVING_FROM_DB);
        }
        return airline.get();
    }

    public Airline saveAirline(Airline airline) {
        Airline res;
        try {
            res = airlineRepository.save(airline);
        } catch (Exception e) {
            throw new DBException(ERROR_SAVING_TO_DB);
        }
        return res;
    }

    public Iterable<Airline> findAll() {
        Iterable<Airline> airlineIterable;
        try {
            airlineIterable = airlineRepository.findAll();
        } catch (Exception e) {
            throw new DBException(ERROR_RETRIEVING_FROM_DB);
        }
        return airlineIterable;
    }
}
