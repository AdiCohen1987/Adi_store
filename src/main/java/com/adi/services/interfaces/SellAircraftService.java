package com.adi.services.interfaces;

import com.adi.dataModel.interfaces.SellAircraftDataModel;

public interface SellAircraftService {
    SellAircraftDataModel sellAircraft(Long sellerAirlineId, Long buyerAirlineId, Long aircraftId);
}
