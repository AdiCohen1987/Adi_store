package com.adi.controller;

import com.adi.dataModel.impl.NewAirlineAircraftDataModelImpl;
import com.adi.dataModel.impl.NewAirlineDataModelImpl;
import com.adi.dataModel.interfaces.SellAircraftDataModel;
import com.adi.persistence.model.Airline;
import com.adi.persistence.model.AirlineAircrafts;
import com.adi.persistence.model.AirlineLocations;
import com.adi.services.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagementSystemController {

    @Autowired
    private AirlineManagementService airlineManagementService;

    @Autowired
    private SellAircraftService sellAircraftService;

    @Autowired
    private AddAircraftToAirlineService addAircraftToAirline;

    @Autowired
    private LocationService locationService;


    @PostMapping("/addAirline")
    public ResponseEntity<Airline> newAirline(@RequestBody NewAirlineDataModelImpl newAirline) {
        Airline airline = airlineManagementService.addNewAirline(newAirline);
        return new ResponseEntity<>(airline, HttpStatus.CREATED);
    }

    @PostMapping("/airline/{id}/addNewLocation")
    public ResponseEntity<AirlineLocations> newLocation(@RequestBody AirlineLocations airlineLocation, @PathVariable("id") Long airlineId) {
        AirlineLocations result = locationService.addLocation(airlineLocation,airlineId);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PostMapping("/airline/{id}/getLocationsByAirline")
    public ResponseEntity<List<AirlineLocations>> newLocation(@PathVariable("id") Long airlineId) {
        List<AirlineLocations> result = locationService.getAllLocationsByAirline(airlineId);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/airlines")
    public ResponseEntity<List<String>> getAirlinesWithCurrentBudget() {
        List<String> airlinesWithCurrentBudget = airlineManagementService.getAirlinesWithCurrentBudget();
        return new ResponseEntity<>(airlinesWithCurrentBudget, HttpStatus.OK);
    }


    @PostMapping("/airline/{id}/addAircraftToAirline")
    public ResponseEntity<AirlineAircrafts> addAircraftToAirline(@RequestBody NewAirlineAircraftDataModelImpl airlineAircraftDataModel, @PathVariable("id") Long airlineIid) {
        AirlineAircrafts airlineAircrafts = addAircraftToAirline.addAircraftToAirline(airlineAircraftDataModel, airlineIid);
        return new ResponseEntity<>(airlineAircrafts, HttpStatus.OK);
    }

    @PostMapping("/sellAircraft")
    public ResponseEntity<SellAircraftDataModel> sellAircraft(@RequestParam Long sellerAirlineId, @RequestParam Long buyerAirlineId, @RequestParam Long aircraftId) {
        SellAircraftDataModel sellAircraftDataModel = sellAircraftService.sellAircraft(sellerAirlineId, buyerAirlineId, aircraftId);
        return new ResponseEntity<>(sellAircraftDataModel, HttpStatus.OK);

    }

}

