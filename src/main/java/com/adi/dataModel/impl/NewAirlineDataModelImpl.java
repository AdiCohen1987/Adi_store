package com.adi.dataModel.impl;


import com.adi.dataModel.interfaces.NewAirlineDataModel;
import org.springframework.stereotype.Service;

@Service
public class NewAirlineDataModelImpl implements NewAirlineDataModel {

    private String airlineName;

    private int initialBudget;

    private String homeBaseName;

    private double altitude;

    private double longitude;

    public NewAirlineDataModelImpl() {
        super();
    }

    public NewAirlineDataModelImpl(String airlineName, int initialBudget, String homeBaseName, double altitude, double longitude) {
        this.airlineName = airlineName;
        this.initialBudget = initialBudget;
        this.homeBaseName = homeBaseName;
        this.altitude = altitude;
        this.longitude = longitude;
    }

    @Override
    public String getAirlineName() {
        return airlineName;
    }

    @Override
    public void setAirlineName(String name) {
        this.airlineName = name;
    }

    @Override
    public int getInitialBudget() {
        return initialBudget;
    }

    @Override
    public void setInitialBudget(int initialBudget) {
        this.initialBudget = initialBudget;
    }

    @Override
    public String getHomeBaseName() {
        return homeBaseName;
    }

    @Override
    public void setHomeBaseName(String homeBaseName) {
        this.homeBaseName = homeBaseName;
    }

    @Override
    public double getAltitude() {
        return altitude;
    }

    @Override
    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    @Override
    public double getLongitude() {
        return longitude;
    }

    @Override
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
