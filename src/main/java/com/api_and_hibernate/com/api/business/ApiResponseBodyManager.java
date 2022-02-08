package com.api_and_hibernate.com.api.business;
import com.api_and_hibernate.com.api.dataAccess.ApiResponseDatabaseJpaRepositoryDao;
import com.api_and_hibernate.com.api.weather.dataAccess.ApiResponseDatabaseJpaRepositoryWeatherDao;
import com.api_and_hibernate.com.api.dtos.ApiResponseBody;
import com.api_and_hibernate.com.api.dtos.ApiResponseDataBaseEntity;
import com.api_and_hibernate.com.api.weather.entities.ApiResponseDatabaseWeather;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiResponseBodyManager implements ApiResponseBodyService{


    private ApiResponseDatabaseJpaRepositoryDao apiJpaRepositoryDao;



    @Autowired
    public ApiResponseBodyManager(ApiResponseDatabaseJpaRepositoryDao apiJpaRepositoryDao) {
        this.apiJpaRepositoryDao=apiJpaRepositoryDao;
    }

    @Value("${uri}")
    private String uri;

    public void get(ApiResponseBody body){
        String al=String.format("{ \n " +
                        "coord:{ lon: %s, lat: %s }, \n" +
                        " weather:[{ id: %s, main: %s, description: %s, icon: %s }], \n" + " base: %s, \n" +
                        " main:{ temp: %s, feels_like: %s, temp_min: %s temp_max: %s, pressure: %s, humidity: %s }, \n" +
                        " visibility: %s, \n" +
                        " wind:{ speed:%s, deg: %s }, \n" +
                        " clouds:{ all: %s }," +
                        " dt: %s, \n" +
                        " sys:{ type: %s, id: %s, message: %s, country: %s, sunrise: %s, sunset: %s }, \n" +
                        " timezone: %s, \n" +
                        " id: %s, \n" +
                        " name: %s, \n" +
                        " code: %s \n" +
                        "}",body.getCoord().getLon(),body.getCoord().getLat(),body.getWeather()[0].getId(),body.getWeather()[0].getMain(),body.getWeather()[0].getDescription(),
                body.getWeather()[0].getIcon(),body.getBase(),body.getMain().getTemp(),body.getMain().getFeels_like(),body.getMain().getTemp_min(),body.getMain().getTemp_max(),
                body.getMain().getPressure(),body.getMain().getHumidity(),body.getVisibility(),body.getWind().getSpeed(),body.getWind().getDeg(),body.getWind().getGust(),body.getClouds().getAll(),body.getDt(),
                body.getSys().getType(),body.getSys().getId(),body.getSys().getCountry(),body.getSys().getSunrise(),body.getSys().getSunset(),body.getTimezone(),body.getId(),body.getName(),body.getCod());


        System.out.println(al);

    }

    @Override
    public void getData() {
        ApiResponseDataBaseEntity entity=new ApiResponseDataBaseEntity();

        RestTemplate template=new RestTemplate();
        String responseBody=template.getForObject(uri,String.class);

        JSONObject apiResponse = new JSONObject(responseBody);
        entity.setCoord_lat(apiResponse.getJSONObject("coord").getDouble("lat"));
        entity.setCoord_lon(apiResponse.getJSONObject("coord").getDouble("lon"));


        /*entity.setCoord_lat(responseBody.getCoord().getLat());
        entity.setCoord_lon(responseBody.getCoord().getLon());
        entity.setWeather_description(responseBody.getWeather()[0].getDescription());
        entity.setWeather_icon(responseBody.getWeather()[0].getIcon());
        entity.setWeather_id(responseBody.getWeather()[0].getId());
        entity.setWeather_main(responseBody.getWeather()[0].getMain());

        get(responseBody);*/
        apiJpaRepositoryDao.save(entity);


    }

    @Override
    public void delete(int id) {

    }




}
