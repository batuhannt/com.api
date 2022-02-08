package com.api_and_hibernate.com.api.dataAccess;

import com.api_and_hibernate.com.api.weather.entities.ApiResponseDatabaseWeather;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

public class ApiResponseDatabaseWeatherDao {

    private EntityManager entityManager;

    @Autowired
    public ApiResponseDatabaseWeatherDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void add(ApiResponseDatabaseWeather entity){
        Session session=entityManager.unwrap(Session.class);
        session.saveOrUpdate(entity);
    }
}
