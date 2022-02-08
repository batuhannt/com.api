package com.api_and_hibernate.com.api.weather.entities;

import javax.persistence.*;

@Entity
@Table(name = "weather")
public class ApiResponseDatabaseWeather {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int weather_id;

    @Column(name="main")
    private String weather_main;

    @Column(name = "description")
    private String weather_description;

    @Column(name="icon")
    private String weather_icon;

    public ApiResponseDatabaseWeather(int weather_id, String weather_main, String weather_description, String weather_icon) {
        this.weather_id = weather_id;
        this.weather_main = weather_main;
        this.weather_description = weather_description;
        this.weather_icon = weather_icon;
    }

    public ApiResponseDatabaseWeather(){}

    public double getWeather_id() {
        return weather_id;
    }

    public void setWeather_id(int weather_id) {
        this.weather_id = weather_id;
    }

    public String getWeather_main() {
        return weather_main;
    }

    public void setWeather_main(String weather_main) {
        this.weather_main = weather_main;
    }

    public String getWeather_description() {
        return weather_description;
    }

    public void setWeather_description(String weather_description) {
        this.weather_description = weather_description;
    }

    public String getWeather_icon() {
        return weather_icon;
    }

    public void setWeather_icon(String weather_icon) {
        this.weather_icon = weather_icon;
    }


}
