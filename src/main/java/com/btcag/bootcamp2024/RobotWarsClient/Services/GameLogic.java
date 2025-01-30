package com.btcag.bootcamp2024.RobotWarsClient.Services;

import com.btcag.bootcamp2024.RobotWarsClient.Enums.*;
import com.btcag.bootcamp2024.RobotWarsClient.Models.*;

//hier logik für ausführen v bewegungen

public class GameLogic {
    public void executeMove(Robot player, Robot target, Move move){
        switch (move.getMovementType()){
            case MOVE:
                moveRobot(player, move.getDirections());
                break;
            case ATTACK:
                attack(player, target);
                break;
            case ALIGN:
                alignRobot(player, move.getDirections());
                break;
            case END:
                endTurn();
                break;
        }
    }
    private void moveRobot(Robot player, Directions directions){
        if(Map.validTurn(directions,  player)) {
            player.setX(player.getX() + directions.getX());
            player.setY(player.getY() + directions.getY());
        }else{
            System.out.println("Ungültiger Zug. ");
        }
    }
    private void attack(Robot player, Robot target){
        if (RobotService.inRange(player, target)){
            Robot.attack(player, target);
        }
    }

    private void alignRobot(Robot player, Directions directions){
        //Angriffslogik je nach align hier
    }

    private void endTurn(){
        //ZUg beenden hier
    }
}
