package com.jagardner21.weather_app_api.model;

import lombok.Data;

@Data
public class Wind {
    private double speed;
    private int deg;
    private double gust;

    // getters and setters
    public double getSpeed() {
        return speed;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public int getDeg() {
        return deg;
    }
    public void setDeg(int deg) {
        this.deg = deg;
    }
    public double getGust() {
        return gust;
    }
    public void setGust(double gust) {
        this.gust = gust;
    }
}
