package com.adi.dataModel.impl;


import com.adi.dataModel.interfaces.NewAirlineAircraftDataModel;
import org.springframework.stereotype.Service;

@Service
public class NewAirlineAircraftDataModelImpl implements NewAirlineAircraftDataModel {

    private String aircraftName;

    private int price;

    private int maxDistance;

    private Integer serviceMonth;

    private Integer serviceYear;

    public NewAirlineAircraftDataModelImpl() {
        super();
    }

    public NewAirlineAircraftDataModelImpl(String aircraftName, int price, int maxDistance, Integer serviceMonth, Integer serviceYear) {
        this.aircraftName = aircraftName;
        this.price = price;
        this.maxDistance = maxDistance;
        this.serviceMonth = serviceMonth;
        this.serviceYear = serviceYear;
    }

    @Override
    public Integer getServiceMonth() {
        return serviceMonth;
    }
    @Override
    public void setServiceMonth(Integer serviceMonth) {
        this.serviceMonth = serviceMonth;
    }

    @Override
    public Integer getServiceYear() {
        return serviceYear;
    }

    @Override
    public void setServiceYear(Integer serviceYear) {
        this.serviceYear = serviceYear;
    }

    @Override
    public String getAircraftName() {
        return aircraftName;
    }

    @Override
    public void setAircraftName(String aircraftName) {
        this.aircraftName = aircraftName;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int getMaxDistance() {
        return maxDistance;
    }

    @Override
    public void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }
}
