package com.btcag.bootcamp2024.RobotWarsClient.Controllers;

import com.btcag.bootcamp2024.RobotWarsClient.Models.*;
import com.btcag.bootcamp2024.RobotWarsClient.Services.ApiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RobotController {

    private List<GameRobot> robotList = new ArrayList<>();
    private final ApiService apiService;

    public RobotController(ApiService apiService) {
        this.apiService = apiService;
    }

    @PostMapping("/robots")
    public ResponseEntity<String> addRobot(@RequestBody GameRobot robot, @RequestParam int x, @RequestParam int y) {
        if (robot == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Roboter konnte nicht erstellt werden.");
        }
            robot.setX(x);
            robot.setY(y);
            robotList.add(robot);

            String response = apiService.registerRobot(robot);
            if (response != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Roboter erfolgreich hinzugefügt!!");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Roboter wurde nicht hinzugefügt.");
            }
        }
        @GetMapping("/robots")
        public ResponseEntity<List<GameRobot>> getRobots() {
            return ResponseEntity.ok(robotList);
        }
}
