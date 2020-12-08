package com.adi.dataModel.interfaces;


public interface SellAircraftDataModel {


    String getAirCraftName();

    void setAirCraftName(String airCraftName);

    String getSellerName();

    void setSellerName(String sellerName);

    String getBuyerName();

    void setBuyerName(String buyerName);

    double getSalePrice();

    void setSalePrice(double salePrice);

    double getSellerCurrentBudget();

    void setSellerCurrentBudget(double sellerCurrentBudget);

    double getBuyerCurrentBudget();

    void setBuyerCurrentBudget(double buyerCurrentBudget);
}
