package com.btcag.bootcamp2024.RobotWarsClient.Controllers;

import com.btcag.bootcamp2024.RobotWarsClient.Models.Robot;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RobotController {

    private List<Robot> robotList = new ArrayList<>();

    @PostMapping("/robots")
    public ResponseEntity<String> addRobot(@RequestBody Robot robot, @RequestParam int x, @RequestParam int y) {
        if (robot != null) {
            robot.setX(x);
            robot.setY(y);
            robotList.add(robot);

            String jsonInputString = String.format("{\"name\": \"%s\", \"health\": %d, \"movementRate\": %d, \"attackDamage\": %d, \"attackRange\": %d}",
                    robot.getName(), robot.getHealth(), robot.getMovementRange(), robot.getAttackDamage(), robot.getAttackRange());
            String url = "https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/api/robots/robot";
            sendPostRequest(url, jsonInputString);

            return ResponseEntity.status(HttpStatus.CREATED).body("Roboter erfolgreich hinzugefügt!!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ungültiger Roboter wird nicht hinzugefügt.");
        }
    }

    @GetMapping("/robots")
    public ResponseEntity<List<Robot>> getRobots() {
        return ResponseEntity.ok(robotList);
    }

    private void sendPostRequest(String url, String jsonInputString) {
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);

            try (OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println(response.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}