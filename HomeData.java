package com.example.homework;

import com.google.gson.annotations.SerializedName;
public class HomeData {

    @SerializedName("bedrooms")
    public double bedrooms;

    @SerializedName("bathrooms")
    public double bathrooms;

    @SerializedName("city")
    public String city;

    @SerializedName("zipcode")
    public String zipCode;

    @SerializedName("streetAddress")
    public String streetAddress;

    @SerializedName("homeType")
    public String homeType;

    @SerializedName("price")
    public double price;

    @SerializedName("imgSrc")
    public String imgSrc;

    public double getBedrooms(){return bedrooms;}

    public double getBathrooms() {return bathrooms;}

    public double getPrice() {return price;}

    public String getStreetAddress() {return streetAddress;}

    public String getCity() {return city;}

    public String getZipCode() {return zipCode;}
    public String getFullAddress() {return ("" + streetAddress + ", " + city + ", WA " + zipCode);}

    public String getHomeType() {return homeType;}

    public String getImgSrc() {return imgSrc;}
}
