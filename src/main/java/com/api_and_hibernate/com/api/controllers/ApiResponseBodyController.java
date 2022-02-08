package com.api_and_hibernate.com.api.controllers;

import com.api_and_hibernate.com.api.business.ApiResponseBodyService;
import com.api_and_hibernate.com.api.dtos.ApiResponseBody;
import com.api_and_hibernate.com.api.entities.Weather;
import com.api_and_hibernate.com.api.weather.business.WeatherManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Timer;
import java.util.TimerTask;

@RestController
@RequestMapping("/api")
public class ApiResponseBodyController {

    private WeatherManager weatherManager;

    private ApiResponseBodyService apiResponseBodyService;

    @Autowired
    public ApiResponseBodyController(ApiResponseBodyService apiResponseBodyService,WeatherManager weatherManager) {
        this.apiResponseBodyService = apiResponseBodyService;
        this.weatherManager=weatherManager;
    }
    //@Scheduled(fixedRate = 4000)
    @GetMapping("/get")
    public String get(){
        apiResponseBodyService.getData();
        weatherManager.getData();
        return "Başarılı";
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        apiResponseBodyService.delete(id);

    }
}
