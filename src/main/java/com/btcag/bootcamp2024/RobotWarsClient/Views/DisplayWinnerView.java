package com.btcag.bootcamp2024.RobotWarsClient.Views;

import com.btcag.bootcamp2024.RobotWarsClient.Models.*;

public class DisplayWinnerView {
    public static void display(GameRobot player, GameRobot target) {
        if (player.getHealth() <= 0) {
            System.out.println(target.getName() + " gewinnt!");
            player.setKnockedOut(true);
        } else if (target.getHealth() <= 0) {
            System.out.println(player.getName() + " gewinnt!");
            target.setKnockedOut(true);
        }
    }
}