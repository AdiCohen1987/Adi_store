package com.adi.dataModel.impl;

import com.adi.dataModel.interfaces.DestinationsToHomeBaseDataModel;

public class DestinationsToHomeBaseDataModelImpl implements DestinationsToHomeBaseDataModel {

    String locationName;

    double distanceFromHomeBase;

    public DestinationsToHomeBaseDataModelImpl(String locationName, double distanceFromHomeBase) {
        this.locationName = locationName;
        this.distanceFromHomeBase = distanceFromHomeBase;
    }

    @Override
    public String getLocationName() {
        return locationName;
    }

    @Override
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @Override
    public double getDistanceFromHomeBase() {
        return distanceFromHomeBase;
    }

    @Override
    public void setDistanceFromHomeBase(double distanceFromHomeBase) {
        this.distanceFromHomeBase = distanceFromHomeBase;
    }
}
