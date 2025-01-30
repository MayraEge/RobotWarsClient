package com.btcag.bootcamp2024.RobotWarsClient.Services;

import com.btcag.bootcamp2024.RobotWarsClient.Controllers.GameController;
import com.btcag.bootcamp2024.RobotWarsClient.Models.*;
import com.btcag.bootcamp2024.RobotWarsClient.Views.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;

//user input bei start des programms
@Component
public class CommandLineRunnerService implements CommandLineRunner {
    private final RestTemplate restTemplate;
    private final GameController gameController;

    public CommandLineRunnerService(RestTemplate restTemplate, GameController gameController) {
        this.restTemplate = restTemplate;
        this.gameController = gameController;
    }

    @Override
    public void run(String... args) throws Exception {
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
        System.out.print("Geben Sie den Namen des neuen Spiels ein: ");
        String gameName = scanner.nextLine();

        System.out.print("Geben Sie den Namen Ihres Roboters ein: ");
        String robotName = scanner.nextLine();

        Robot player = new Robot(robotName, "", 0, 0, 0, 0, false);
        AskSkillPointsView.setStats(player);

        // Erstelle ein neues Spiel über den GameController
        Game newGame = new Game("", gameName, new Map(15, 10), 1);
        gameController.addGame(newGame);

        System.out.println("Neues Spiel '" + gameName + "' wurde erstellt!");
        AskSkillPointsView.display(player);
    }

    private void joinExistingGame(Scanner scanner) {
        System.out.print("Geben Sie die ID des bestehenden Spiels ein: ");
        String gameId = scanner.nextLine();

        System.out.print("Geben Sie den Namen Ihres Roboters ein: ");
        String robotName = scanner.nextLine();

        Robot player = new Robot(robotName, "",0,0,0,0,false);
        AskSkillPointsView.setStats(player);

        // Trete einem bestehenden Spiel über GameController bei
        gameController.joinGame(gameId, player.getName());

        System.out.println("Sie sind dem Spiel '" + gameId + "' beigetreten!");
        AskSkillPointsView.display(player);
    }
    private String getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}