package com.btcag.bootcamp2024.RobotWarsClient.Views;

import com.btcag.bootcamp2024.RobotWarsClient.Enums.Directions;
import com.btcag.bootcamp2024.RobotWarsClient.Services.RobotService;

import java.util.Scanner;

public class MoveRobotView {
    public static Directions turn() {
        Scanner scanner = new Scanner(System.in);
        Directions direction;
        System.out.println("Bitte geben Sie an, in welche Richtung Sie sich bewegen wollen (NUMPad). Die 5 drücken, um Position zu halten: ");
        do {
            direction = (Directions) RobotService.fromUserInput(scanner.nextInt());
        } while (null == direction);
        return direction;
    }
}