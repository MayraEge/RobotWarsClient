package com.btcag.bootcamp2024.RobotWarsClient.Views;
import com.btcag.bootcamp2024.RobotWarsClient.Models.Map;
import com.btcag.bootcamp2024.RobotWarsClient.Models.Robot;

import java.util.List;

public class BattlefieldView {
    public static void display(List<Robot> robots, Map map) {
        for (int y = 0; y < map.getHeight(); y++) {
            for (int x = 0; x < map.getWidth(); x++) {
                if (x == robots.get(0).getX() && y == robots.get(0).getY()) {
                    System.out.print(robots.get(0).getName());
                } else if (x == robots.get(1).getX() && y == robots.get(1).getY()) {
                    System.out.print(robots.get(1).getName());
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }
}