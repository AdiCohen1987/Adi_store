package com.adi.persistence.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class AirlineLocations {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private long airlineId;

    @Column(nullable = false)
    private String airlineName;

    @Column(nullable = false)
    private String locationName;

    @Column(nullable = false)
    private double altitude;

    @Column(nullable = false)
    private double longitude;

    public AirlineLocations() {
        super();
    }

    public AirlineLocations(long airlineId,String airlineName, String locationName, double altitude, double longitude) {
        this.airlineId = airlineId;
        this.airlineName = airlineName;
        this.locationName = locationName;
        this.altitude = altitude;
        this.longitude = longitude;
    }

    public long getId() {
        return id;
    }


    public long getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(long airlineId) {
        this.airlineId = airlineId;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirlineLocations that = (AirlineLocations) o;
        return id == that.id &&
                airlineId == that.airlineId &&
                airlineName.equals(that.airlineName) &&
                locationName.equals(that.locationName) &&
                Double.compare(that.altitude, altitude) == 0 &&
                Double.compare(that.longitude, longitude) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, airlineId, altitude, longitude);
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}