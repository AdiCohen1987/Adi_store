package com.adi.persistence.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class AirlineAircrafts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private long airlineId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int maxDistance;

    @Column(nullable = false)
    private int serviceMonth;

    @Column(nullable = false)
    private int serviceYear;

    public AirlineAircrafts(long airlineId, String name, int price, int maxDistance, int serviceMonth, int serviceYear) {
        this.airlineId = airlineId;
        this.name = name;
        this.price = price;
        this.maxDistance = maxDistance;
        this.serviceMonth = serviceMonth;
        this.serviceYear = serviceYear;
    }

    public AirlineAircrafts() {
        super();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public int getServiceMonth() {
        return serviceMonth;
    }

    public void setServiceMonth(int serviceMonth) {
        this.serviceMonth = serviceMonth;
    }

    public int getServiceYear() {
        return serviceYear;
    }

    public void setServiceYear(int serviceYear) {
        this.serviceYear = serviceYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirlineAircrafts that = (AirlineAircrafts) o;
        return id == that.id &&
                airlineId == that.airlineId &&
                price == that.price &&
                maxDistance == that.maxDistance &&
                serviceMonth == that.serviceMonth &&
                serviceYear == that.serviceYear &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, airlineId, name, price, maxDistance, serviceMonth, serviceYear);
    }
}