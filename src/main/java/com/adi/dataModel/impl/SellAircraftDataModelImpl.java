package com.adi.dataModel.impl;


import com.adi.dataModel.interfaces.SellAircraftDataModel;

public class SellAircraftDataModelImpl implements SellAircraftDataModel {

    String airCraftName;

    String sellerName;

    String buyerName;

    double sellerCurrentBudget;

    double buyerCurrentBudget;

    double salePrice;

    public SellAircraftDataModelImpl() {
        super();
    }

    public SellAircraftDataModelImpl(String airCraftName, String sellerName, String buyerName, double sellerCurrentBudget, double buyerCurrentBudget, double salePrice) {
        this.airCraftName = airCraftName;
        this.sellerName = sellerName;
        this.buyerName = buyerName;
        this.sellerCurrentBudget = sellerCurrentBudget;
        this.buyerCurrentBudget = buyerCurrentBudget;
        this.salePrice = salePrice;
    }

    @Override
    public String getAirCraftName() {
        return airCraftName;
    }

    @Override
    public void setAirCraftName(String airCraftName) {
        this.airCraftName = airCraftName;
    }

    @Override
    public String getSellerName() {
        return sellerName;
    }

    @Override
    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    @Override
    public String getBuyerName() {
        return buyerName;
    }

    @Override
    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    @Override
    public double getSalePrice() {
        return salePrice;
    }

    @Override
    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    @Override
    public double getSellerCurrentBudget() {
        return sellerCurrentBudget;
    }

    @Override
    public void setSellerCurrentBudget(double sellerCurrentBudget) {
        this.sellerCurrentBudget = sellerCurrentBudget;
    }

    @Override
    public double getBuyerCurrentBudget() {
        return buyerCurrentBudget;
    }

    @Override
    public void setBuyerCurrentBudget(double buyerCurrentBudget) {
        this.buyerCurrentBudget = buyerCurrentBudget;
    }
}
