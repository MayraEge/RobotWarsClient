package com.btcag.bootcamp2024.RobotWarsClient.Services;

import com.btcag.bootcamp2024.RobotWarsClient.Models.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {
    private final RestTemplate restTemplate;

    @Value("${api.url}")
    private String apiUrl;

    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
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
        return restTemplate.getForObject(url, String.class);
    }
}