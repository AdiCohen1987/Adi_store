package com.adi.controller;

import com.adi.dataModel.impl.NewAirlineAircraftDataModelImpl;
import com.adi.dataModel.impl.NewAirlineDataModelImpl;
import com.adi.dataModel.interfaces.SellAircraftDataModel;
import com.adi.persistence.model.Airline;
import com.adi.persistence.model.AirlineAircrafts;
import com.adi.persistence.model.AirlineLocations;
import com.adi.services.interfaces.AddAircraftToAirlineService;
import com.adi.services.interfaces.AirlineManagementService;
import com.adi.services.interfaces.LocationService;
import com.adi.services.interfaces.SellAircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sellAircraft")
public class SellAircarftManagementSystemController {

    @Autowired
    private SellAircraftService sellAircraftService;


    @PostMapping("/")
    public ResponseEntity<SellAircraftDataModel> sellAircraft(@RequestParam Long sellerAirlineId, @RequestParam Long buyerAirlineId, @RequestParam Long aircraftId) {
        SellAircraftDataModel sellAircraftDataModel = sellAircraftService.sellAircraft(sellerAirlineId, buyerAirlineId, aircraftId);
        return new ResponseEntity<>(sellAircraftDataModel, HttpStatus.OK);

    }

}

