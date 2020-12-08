package com.adi.persistence;

import com.adi.configuration.errorHandling.DBException;
import com.adi.configuration.errorHandling.EntityNotFoundException;
import com.adi.persistence.model.Airline;
import com.adi.persistence.repo.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.adi.configuration.errorHandling.ErrorConstants.ERROR_RETRIEVING_FROM_DB;
import static com.adi.configuration.errorHandling.ErrorConstants.ERROR_SAVING_TO_DB;

@Service
public class LocationRepositoryGateway {

    //TODO need to add here gateways and remove from service class.
}
