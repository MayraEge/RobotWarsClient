package com.btcag.bootcamp2024.RobotWarsClient.Views;

import java.util.Scanner;


public class AskRobotNameView {
    public static String display() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte wählen Sie ein Zeichen für Ihren Roboter aus:");
        System.out.println("Geben Sie 1 ein für X");
        System.out.println("Geben Sie 2 ein für #");
        System.out.println("Geben Sie 3 ein für $");

        int robotSelected = 0;
        while (robotSelected <= 0 || robotSelected >= 4) {
            robotSelected = scanner.nextInt();
        }

        if (robotSelected == 1) {
            return "[X]";
        } else if (robotSelected == 2) {
            return "[#]";
        } else {
            return "[$]";
        }
    }
}