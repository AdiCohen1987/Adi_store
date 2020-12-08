package com.adi.dataModel.interfaces;

public interface DestinationsToHomeBaseDataModel {
    abstract String getLocationName();

    void setLocationName(String locationName);

    double getDistanceFromHomeBase();

    void setDistanceFromHomeBase(double distanceFromHomeBase);
}
