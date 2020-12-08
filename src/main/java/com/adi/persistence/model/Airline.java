package com.adi.persistence.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false,unique = true)
    private String name;

    @Column(nullable = false)
    private double initialBudget;

    @Column(nullable = false)
    private double currentBudget;

    @Column(nullable = false)
    private String homeBaseName;

    public Airline() {
        super();
    }

    public Airline(String name, double initialBudget,double currentBudget, String homeBaseId) {
        this.name = name;
        this.initialBudget = initialBudget;
        this.currentBudget = currentBudget;
        this.homeBaseName = homeBaseId;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getInitialBudget() {
        return initialBudget;
    }

    public void setInitialBudget(double initialBudget) {
        this.initialBudget = initialBudget;
    }

    public String getHomeBaseName() {
        return homeBaseName;
    }

    public void setHomeBaseName(String homeBaseName) {
        this.homeBaseName = homeBaseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airline airline = (Airline) o;
        return id == airline.id &&
                initialBudget == airline.initialBudget &&
                name.equals(airline.name) &&
                homeBaseName.equals(airline.homeBaseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, initialBudget);
    }

    public double getCurrentBudget() {
        return currentBudget;
    }

    public void setCurrentBudget(double currentBudget) {
        this.currentBudget = currentBudget;
    }
}