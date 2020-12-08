package com.adi.controller;

import com.adi.dataModel.impl.NewAirlineAircraftDataModelImpl;
import com.adi.dataModel.impl.NewAirlineDataModelImpl;
import com.adi.dataModel.interfaces.DestinationsToHomeBaseDataModel;
import com.adi.persistence.model.Airline;
import com.adi.persistence.model.AirlineAircrafts;
import com.adi.persistence.model.AirlineLocations;
import com.adi.services.interfaces.AddAircraftToAirlineService;
import com.adi.services.interfaces.AirlineManagementService;
import com.adi.services.interfaces.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airline")
public class AirlineManagementSystemController {

    @Autowired
    private AirlineManagementService airlineManagementService;

    @Autowired
    private AddAircraftToAirlineService addAircraftToAirline;

    @Autowired
    private LocationService locationService;


    @PostMapping("/addAirline")
    public ResponseEntity<Airline> newAirline(@RequestBody NewAirlineDataModelImpl newAirline) {
        Airline airline = airlineManagementService.addNewAirline(newAirline);
        return new ResponseEntity<>(airline, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/addNewLocation")
    public ResponseEntity<AirlineLocations> newLocation(@RequestBody AirlineLocations airlineLocation, @PathVariable("id") Long airlineId) {
        AirlineLocations result = locationService.addLocation(airlineLocation, airlineId);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/getLocationsByAirline")
    public ResponseEntity<List<AirlineLocations>> getLocationsByAirline(@PathVariable("id") Long airlineId) {
        List<AirlineLocations> result = locationService.getAllLocationsByAirline(airlineId);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/getAirlinesWithCurrentBudget")
    public ResponseEntity<List<String>> getAirlinesWithCurrentBudget() {
        List<String> airlinesWithCurrentBudget = airlineManagementService.getAirlinesWithCurrentBudget();
        return new ResponseEntity<>(airlinesWithCurrentBudget, HttpStatus.OK);
    }

    @GetMapping("/{id}/getDestinationsToHomeBase")
    public ResponseEntity<List<DestinationsToHomeBaseDataModel>> getDestinationsToHomeBase(@PathVariable("id") Long airlineId) {
        List<DestinationsToHomeBaseDataModel> destinations = locationService.getDestinationsToHomeBase(airlineId);
        return new ResponseEntity<>(destinations, HttpStatus.OK);
    }

    @GetMapping("/{id}/getAvailableDestinations")
    public ResponseEntity<List<String>> getAvailableDestinations(@PathVariable("id") Long airlineId) {
        List<String> destinations = locationService.getAvailableDestinations(airlineId);
        return new ResponseEntity<>(destinations, HttpStatus.OK);
    }


    @PostMapping("/{id}/addAircraftToAirline")
    public ResponseEntity<AirlineAircrafts> addAircraftToAirline(@RequestBody NewAirlineAircraftDataModelImpl airlineAircraftDataModel, @PathVariable("id") Long airlineIid) {
        AirlineAircrafts airlineAircrafts = addAircraftToAirline.addAircraftToAirline(airlineAircraftDataModel, airlineIid);
        return new ResponseEntity<>(airlineAircrafts, HttpStatus.CREATED);
    }

}

