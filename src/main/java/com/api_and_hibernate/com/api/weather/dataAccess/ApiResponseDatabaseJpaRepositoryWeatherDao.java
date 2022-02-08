package com.api_and_hibernate.com.api.weather.dataAccess;

import com.api_and_hibernate.com.api.weather.entities.ApiResponseDatabaseWeather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiResponseDatabaseJpaRepositoryWeatherDao extends JpaRepository<ApiResponseDatabaseWeather,Integer> {
}
