package com.adi.persistence.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int initialBudget;

    @Column(nullable = false)
    private int currentBudget;

    @Column(nullable = false)
    private Long homeBaseId;

    public Airline() {
        super();
    }

    public Airline(String name, int initialBudget, Long homeBaseId) {
        this.name = name;
        this.initialBudget = initialBudget;
        this.homeBaseId = homeBaseId;
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

    public int getInitialBudget() {
        return initialBudget;
    }

    public void setInitialBudget(int initialBudget) {
        this.initialBudget = initialBudget;
    }

    public Long getHomeBaseId() {
        return homeBaseId;
    }

    public void setHomeBaseId(Long homeBaseId) {
        this.homeBaseId = homeBaseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airline airline = (Airline) o;
        return id == airline.id &&
                initialBudget == airline.initialBudget &&
                name.equals(airline.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, initialBudget);
    }

    public int getCurrentBudget() {
        return currentBudget;
    }

    public void setCurrentBudget(int currentBudget) {
        this.currentBudget = currentBudget;
    }
}