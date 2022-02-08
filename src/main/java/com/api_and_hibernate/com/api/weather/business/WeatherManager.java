package com.api_and_hibernate.com.api.weather.business;

import com.api_and_hibernate.com.api.weather.dataAccess.ApiResponseDatabaseJpaRepositoryWeatherDao;
import com.api_and_hibernate.com.api.weather.entities.ApiResponseDatabaseWeather;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherManager {

    @Value("${uri}")
    private String uri;

    private ApiResponseDatabaseJpaRepositoryWeatherDao apiJpaRepositoryWeatherDao;

    public WeatherManager(ApiResponseDatabaseJpaRepositoryWeatherDao apiJpaRepositoryWeatherDao){
            this.apiJpaRepositoryWeatherDao=apiJpaRepositoryWeatherDao;
    }

    public void getData(){
        ApiResponseDatabaseWeather weathers=new ApiResponseDatabaseWeather();
        RestTemplate template=new RestTemplate();
        String responseBody=template.getForObject(uri,String.class);

        JSONObject apiResponse = new JSONObject(responseBody);
        JSONArray results = apiResponse.getJSONArray("weather");
        JSONObject weather = results.getJSONObject(0);

        weathers.setWeather_icon(weather.getString("icon"));
        weathers.setWeather_description(weather.getString("description"));
        weathers.setWeather_main(weather.getString("main"));

        apiJpaRepositoryWeatherDao.save(weathers);
    }


}
