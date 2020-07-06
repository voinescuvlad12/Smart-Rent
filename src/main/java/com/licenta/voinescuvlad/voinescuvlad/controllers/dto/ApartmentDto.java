package com.licenta.voinescuvlad.voinescuvlad.controllers.dto;

import javax.validation.constraints.*;

public class ApartmentDto {

    private int apartmentID;

    @NotEmpty(message = "Apartment name must not be empty")
    @Size(min=1, max=20, message="name must be between 1 and 20 characters")
    private String apartmentName;

    @NotEmpty(message = "Please enter a country.")
    @Pattern(regexp = "^[A-Za-z]+$",message = "Country composed only from letters.")
    @Size(min=1, max=20, message="Countrey must be between 1 and 20 characters")
    private String countrey;

    @NotEmpty(message = "Please entry a country name.")
    @Pattern(regexp = "^[A-Za-z]+$",message = "City composed only from letters.")
    private String city;

    @NotEmpty(message = "Please entry an address.")
    private String adress;

    @NotNull(message="Please enter a price per night")
    @Min(value = 1,message = "Minimum price is 1$/night")
    @Max(value = 100000,message = "Maximum price is 100000$/night")
    private double ppn;

    private String userName;

    private String status;

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    public String getCountrey() {
        return countrey;
    }

    public void setCountrey(String countrey) {
        this.countrey = countrey;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public double getPpn() {
        return ppn;
    }

    public void setPpn(double ppn) {
        this.ppn = ppn;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public int getApartmentID() {
        return apartmentID;
    }

    public void setApartmentID(int apartmentID) {
        this.apartmentID = apartmentID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
