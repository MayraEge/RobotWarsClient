package com.btcag.bootcamp2024.RobotWarsClient.Controllers;

import com.btcag.bootcamp2024.RobotWarsClient.Enums.Directions;
import com.btcag.bootcamp2024.RobotWarsClient.Models.Coordinates;
import com.btcag.bootcamp2024.RobotWarsClient.Models.Map;
import com.btcag.bootcamp2024.RobotWarsClient.Models.Robot;
import com.btcag.bootcamp2024.RobotWarsClient.Services.*;
import com.btcag.bootcamp2024.RobotWarsClient.Views.*;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameStarter {
    public static void main(String[] args) throws IOException, InterruptedException {
        //Test
        System.setProperty("sun.net.spi.nameservice.nameservers", "8.8.8.8");
        System.setProperty("sun.net.spi.nameservice.provider.1", "dns,sun");

        HttpService httpService = new HttpService();
        GameController gameController = new GameController(httpService);
        boolean isServerUp = httpService.checkServerStatus("https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/");


        ResponseEntity<String> serverStatus = gameController.checkServerStatus();

        //if (serverStatus.getStatusCode().is2xxSuccessful()) {
        if (isServerUp) {
            System.out.println("Verbindung zum Server erfolgreich hergestellt!");
        }else{
            System.out.println("Keine Verbindung hergestellt. Very sad!");
            return;
        }

        IntroScreenView.display();
        Map map = new Map(15, 10);
        String robotName = AskRobotNameView.display();
        Coordinates defaultCoordinates = new Coordinates(0, 0, 15, 10);
        Robot player = new Robot("1", robotName, 1, 1, 1, 1, false);
        Robot target = new Robot("2", "[O]", 1, 1, 1, 1, false);

        AskSkillPointsView.setStats(player);
        AskSkillPointsView.display(player);

        List<Robot> robots = new ArrayList<>();
        robots.add(player);
        robots.add(target);
        System.out.println("Sie haben folgenden Roboter ausgewählt: " + player.getName());

        BattlefieldView.display(robots, map);
        while (!player.isKnockedOut() && !target.isKnockedOut()) {
            DisplayWinnerView.display(player, target);
            int move = 1;
            while (move <= player.getMovementRange() && !player.isKnockedOut() && !target.isKnockedOut()) {
                Directions direction = MoveRobotView.turn();
                if (Map.validTurn(direction, player)) {
                    player.setX(player.getX() + direction.getX());
                    player.setY(player.getY() + direction.getY());
                    move += 1;
                } else {
                    System.out.println("Zug ungültig.");
                }
                BattlefieldView.display(robots, map);

                if (RobotService.inRange(player, target)) {
                    Robot.attack(player, target);
                    DisplayWinnerView.display(player, target);
                }
            }
        }
    }
}
