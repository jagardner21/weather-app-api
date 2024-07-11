package com.jagardner21.weather_app_api.model;

import lombok.Data;

@Data
public class WeatherDetails {
    private int id;
    private String main;
    private String description;
    private String icon;
}