package com.btcag.bootcamp2024.RobotWarsClient.Controllers;

import com.btcag.bootcamp2024.RobotWarsClient.Enums.Directions;
import com.btcag.bootcamp2024.RobotWarsClient.Models.*;
import com.btcag.bootcamp2024.RobotWarsClient.Services.*;
import com.btcag.bootcamp2024.RobotWarsClient.Views.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class GameStarter implements CommandLineRunner {

    private final ApiService apiService;
    private final GameController gameController;
    private final RobotController robotController;

    public GameStarter(ApiService apiService, GameController gameController, RobotController robotController) {
        this.apiService = apiService;
        this.gameController = gameController;
        this.robotController = robotController;
    }

    @Override
    public void run(String... args) throws IOException, InterruptedException {
        ResponseEntity<String> serverStatus = gameController.checkServerStatus();
        if (serverStatus.getStatusCode().is2xxSuccessful()) {
            System.out.println("Verbindung zum Server erfolgreich hergestellt!");
        } else {
            System.out.println("Keine Verbindung hergestellt. Very sad!");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        IntroScreenView.display();

        int option = InputService.getUserOption(scanner);

        switch (option) {
            case 1:
                createNewGame(scanner);
                break;
            case 2:
                joinExistingGame(scanner);
                break;
            default:
                System.out.println("Was sollte das denn? Wähle bitte (1) oder (2) aus oder geh nach Haus.");
                break;
        }
    }

    private void createNewGame(Scanner scanner) {
        System.out.print("Geben Sie den Namen Ihres Roboters ein: ");
        String robotName = scanner.nextLine();

        Coordinates defaultCoordinates = new Coordinates(0, 0, 15, 10);
        GameRobot player = new GameRobot("", robotName, 1, 1, 1, 1, defaultCoordinates, false, 0, 0);
        AskSkillPointsView.setStats(player);

        // Roboter registrieren
        String registrationResponse = apiService.registerRobot(player);
        if (registrationResponse != null) {
            System.out.println("Roboter erfolgreich registriert!");
        } else {
            System.out.println("Fehler bei der Registrierung des Roboters.");
        }

        // Erstelle ein neues Spiel über den GameController
        Game newGame = new Game("", new Map(15, 10), 1);
        ResponseEntity<String> response = gameController.addGame(newGame);
        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("Neues Spiel wurde erstellt!");
        } else {
            System.out.println("Fehler beim Erstellen des Spiels: " + response.getBody());
        }

        AskSkillPointsView.display(player);

        // Spielmechanik und Anzeige des Spielfelds
        startGame(player, newGame.getMap());
    }

    private void joinExistingGame(Scanner scanner) {
        System.out.print("Geben Sie die ID des bestehenden Spiels ein: ");
        String gameId = scanner.nextLine();

        System.out.print("Geben Sie den Namen Ihres Roboters ein: ");
        String robotName = scanner.nextLine();

        Coordinates defaultCoordinates = new Coordinates(0, 0, 15, 10);
        GameRobot player = new GameRobot("", robotName, 1, 1, 1, 1, defaultCoordinates, false, 0, 0);
        AskSkillPointsView.setStats(player);

        // Roboter registrieren
        String registrationResponse = apiService.registerRobot(player);
        if (registrationResponse != null) {
            System.out.println("Roboter erfolgreich registriert!");
        } else {
            System.out.println("Fehler bei der Registrierung des Roboters.");
        }

        // Trete einem bestehenden Spiel über GameController bei
        ResponseEntity<String> response = gameController.joinGame(gameId, player.getName());
        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("Sie sind dem Spiel '" + gameId + "' beigetreten!");
        } else {
            System.out.println("Fehler beim Beitreten des Spiels: " + response.getBody());
        }

        AskSkillPointsView.display(player);

        // Spielmechanik und Anzeige des Spielfelds
        startGame(player, gameController.getGameMap(gameId));
    }

    private void startGame(GameRobot player, Map map) {
        GameRobot target = new GameRobot("", "[O]", 1, 1, 1, 1, new Coordinates(0, 0, 15, 10), false, 9, 9);
        List<GameRobot> robots = new ArrayList<>();
        robots.add(player);
        robots.add(target);

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
