package com.btcag.bootcamp2024.RobotWarsClient.Models;

public class Player {
    private static int playerCounter;
    public static int getPlayerCounter(){
        return playerCounter;
    }
    public static void setPlayerCounter (int playerCounter){
        Player.playerCounter = playerCounter;
    }
}