package com.btcag.bootcamp2024.RobotWarsClient.Services;

import java.util.InputMismatchException;
import java.util.Scanner;
//hier zentrales input management

public class InputService {
    public static int getUserOption(Scanner scanner){
        int option = -1;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Möchtest du ein neues Spiel erstellen oder einem bestehendem beitreten?");
                System.out.println("Neues Spiel erstellen: 1 ");
                System.out.println("Einem Spiel beitreten: 2 ");
                System.out.println("Bitte (1) oder (2) drücken! ");

                option = scanner.nextInt();
                scanner.nextLine(); // Clear the buffer

                if (option == 1 || option == 2) {
                    validInput = true;
                } else {
                    System.out.println("Ungültige Auswahl. Bitte (1) oder (2) drücken.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ungültige Eingabe. Bitte (1) oder (2) eingeben.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
        return option;
    }

    public static String getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
