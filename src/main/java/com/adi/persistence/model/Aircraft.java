package com.adi.persistence.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int maxDistance;

    public Aircraft() {
        super();
    }

    public Aircraft(long id, String name, int price, int maxDistance) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.maxDistance = maxDistance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aircraft aircraft = (Aircraft) o;
        return id == aircraft.id &&
                price == aircraft.price &&
                maxDistance == aircraft.maxDistance &&
                name.equals(aircraft.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, maxDistance);
    }
}