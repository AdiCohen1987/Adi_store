package com.adi.dataModel.impl;

import com.adi.dataModel.interfaces.AvailableDestinationDataModel;

public class AvailableDestinationDataModelImpl implements AvailableDestinationDataModel {

    String destination;

    public AvailableDestinationDataModelImpl() {
    }

    public AvailableDestinationDataModelImpl(String destination) {
        this.destination = destination;
    }

    @Override
    public String getDestination() {
        return destination;
    }

    @Override
    public void setDestination(String destination) {
        this.destination = destination;
    }
}
