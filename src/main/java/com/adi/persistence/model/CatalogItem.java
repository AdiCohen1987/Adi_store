package com.adi.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class CatalogItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int amountLeft;

    public CatalogItem() {
        super();
    }

    public CatalogItem(long id, String type, String name, double price, int amountLeft) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.price = price;
        this.amountLeft = amountLeft;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmountLeft() {
        return amountLeft;
    }

    public void setAmountLeft(int amountLeft) {
        this.amountLeft = amountLeft;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatalogItem catalogItem = (CatalogItem) o;
        return id == catalogItem.id && catalogItem.name.equals(name) && Double.compare(catalogItem.price, price) == 0 && type.equals(catalogItem.type) && amountLeft == catalogItem.amountLeft;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, name, price, amountLeft);
    }
}