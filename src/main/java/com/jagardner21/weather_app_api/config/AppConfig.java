package com.jagardner21.weather_app_api.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        RestTemplate restTemplate = builder.build();
        restTemplate.setInterceptors(Collections.singletonList(new RequestResponseLoggingInterceptor()));
        return restTemplate;
    }

    private static class RequestResponseLoggingInterceptor implements ClientHttpRequestInterceptor {

        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
            logRequest(request, body);
            ClientHttpResponse response = execution.execute(request, body);
            logResponse(response);
            return response;
        }

        private void logRequest(HttpRequest request, byte[] body) throws IOException {
            System.out.println("Request to: " + request.getURI());
        }

        private void logResponse(ClientHttpResponse response) throws IOException {
            System.out.println("Response status code: " + response.getStatusCode());

            // Efficiently copy the response body to a String
            String responseBody = StreamUtils.copyToString(response.getBody(), StandardCharsets.UTF_8);

            System.out.println("Response bodyxxxx: " + responseBody);

            // Add additional logging or debugging statements here
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response content type: " + response.getHeaders().getContentType());
        }
    }
}