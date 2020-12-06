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
    private long locationId;

    public AirlineLocations(long id, long airlineId, long locationId) {
        this.id = id;
        this.airlineId = airlineId;
        this.locationId = locationId;
    }

    public AirlineLocations() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(long airlineId) {
        this.airlineId = airlineId;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirlineLocations that = (AirlineLocations) o;
        return id == that.id &&
                airlineId == that.airlineId &&
                locationId == that.locationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, airlineId, locationId);
    }
}