package com.api_and_hibernate.com.api.dtos;

import javax.persistence.*;

@Entity
@Table(name="api")
public class ApiResponseDataBaseEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="coord_lon")
    private double coord_lon;

    @Column(name="coord_lat")
    private double coord_lat;


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public double getCoord_lon() {
        return coord_lon;
    }

    public void setCoord_lon(double coord_lon) {
        this.coord_lon = coord_lon;
    }

    public double getCoord_lat() {
        return coord_lat;
    }

    public void setCoord_lat(double coord_lat) {
        this.coord_lat = coord_lat;
    }

    public ApiResponseDataBaseEntity(){}

    public ApiResponseDataBaseEntity(int id, double coord_lon, double coord_lat) {
        this.id = id;
        this.coord_lon = coord_lon;
        this.coord_lat = coord_lat;

    }


}
