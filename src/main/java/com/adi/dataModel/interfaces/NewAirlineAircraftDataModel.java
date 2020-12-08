package com.adi.dataModel.interfaces;


public interface NewAirlineAircraftDataModel {

    Integer getServiceMonth();

    void setServiceMonth(Integer serviceMonth);

    Integer getServiceYear();

    void setServiceYear(Integer serviceYear);

    String getAircraftName();

    void setAircraftName(String aircraftName);

    int getPrice();

    void setPrice(int price);

    int getMaxDistance();

    void setMaxDistance(int maxDistance);
}
