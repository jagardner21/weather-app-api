package com.jagardner21.weather_app_api.service;

import com.jagardner21.weather_app_api.model.WeatherResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${openweathermap.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    @Autowired
    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<WeatherResponse> getWeather(String city) {

        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=imperial";

        WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);
        return ResponseEntity.ok(response);
    }


    // Enable this method to test the RestTemplate and ensure it is working
//    @PostConstruct
//    public void testRestTemplate() {
//        String url = "https://httpbin.org/get";
//        String response = restTemplate.getForObject(url, String.class);
//        System.out.println("Test Response: " + response);
//    }
}