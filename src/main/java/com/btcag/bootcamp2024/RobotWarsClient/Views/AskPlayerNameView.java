package com.btcag.bootcamp2024.RobotWarsClient.Views;

import java.util.Scanner;

public class AskPlayerNameView {
    public static String display() {
        String name;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Bitte gib einen Namen ein (3-15 Zeichen):");
            name = scanner.nextLine();
        } while (name.length() <= 2 || name.length() >= 16);
        return name;
    }
}