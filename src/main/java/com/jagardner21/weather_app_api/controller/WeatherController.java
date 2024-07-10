package com.jagardner21.weather_app_api.controller;

import com.jagardner21.weather_app_api.model.WeatherResponse;
import com.jagardner21.weather_app_api.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    // TODO: base64 encode the apiKey at a minimum
    @GetMapping(value = "/weather", produces = "application/json")
    public ResponseEntity<?> getWeather(@RequestParam String city) {
        return weatherService.getWeather(city);
    }
}
