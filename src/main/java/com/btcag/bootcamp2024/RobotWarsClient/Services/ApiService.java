package com.btcag.bootcamp2024.RobotWarsClient.Services;

import com.btcag.bootcamp2024.RobotWarsClient.Models.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

import java.util.List;

@Service
public class ApiService {
    private final RestTemplate restTemplate;

    @Value("${api.url}")
    private String apiUrl;

    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Robot> getAllRobots() {
        String url = String.format("%s/api/robots", apiUrl);
        ResponseEntity<List<Robot>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Robot>>() {}
        );
        return response.getBody();
    }

    public Robot getRobotById(String robotId) {
        String url = String.format("%s/robots/%s", apiUrl, robotId);
        return restTemplate.getForObject(url, Robot.class);
    }
    public String registerRobot(Robot robot) {
        String url = String.format("%s/robots/register", apiUrl);
        return restTemplate.postForObject(url, robot, String.class);
    }
    public String registerGame(Game game) {
        String url = String.format("%s/games/register", apiUrl);
        return restTemplate.postForObject(url, game, String.class);
    }
    public String checkServerStatus() {
        String url = String.format("%s/status", apiUrl);
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (HttpClientErrorException e) {
            System.err.println("HTTP Error: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
            throw e;
        } catch (RestClientException e) {
            System.err.println("Error: " + e.getMessage());
            throw e;
        }
    }
}