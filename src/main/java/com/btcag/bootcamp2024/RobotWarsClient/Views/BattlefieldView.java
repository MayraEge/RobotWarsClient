package com.btcag.bootcamp2024.RobotWarsClient.Views;
import com.btcag.bootcamp2024.RobotWarsClient.Models.*;

import java.util.List;

public class BattlefieldView {
    public static void display(List<GameRobot> robots, int[][] map) {
        int height = map.length;
        int width = map[0].length;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                boolean robotFound = false;
                for (GameRobot robot : robots) {
                    if (x == robots.get(0).getX() && y == robots.get(0).getY()) {
                        System.out.print(robot.getName());
                        robotFound = true;
                        break;
                    }
                }
                if (!robotFound) {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }
}