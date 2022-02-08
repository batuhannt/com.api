package com.api_and_hibernate.com.api.entities;

public class Sys {
    private double type;
    private double id;
    private String country;
    private double sunrise;
    private double sunset;

    public Sys(){}

    public double getType() {
        return type;
    }

    public void setType(double type) {
        this.type = type;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getSunrise() {
        return sunrise;
    }

    public void setSunrise(double sunrise) {
        this.sunrise = sunrise;
    }

    public double getSunset() {
        return sunset;
    }

    public void setSunset(double sunset) {
        this.sunset = sunset;
    }

    public Sys(double type, double id, String country, double sunrise, double sunset) {
        this.type = type;
        this.id = id;
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }
}
