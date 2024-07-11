package com.jagardner21.weather_app_api.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class WeatherResponseTest {
    @Test
    public void testDeserializeWeatherResponse() throws IOException {
        // Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // Read JSON file and map/convert to Java POJO
        File jsonFile = new File("src/test/resources/sample-openweather-response.json");
        WeatherResponse weatherResponse = objectMapper.readValue(jsonFile, WeatherResponse.class);

        // Verify the deserialized object

        // Add more assertions as needed
    }
}