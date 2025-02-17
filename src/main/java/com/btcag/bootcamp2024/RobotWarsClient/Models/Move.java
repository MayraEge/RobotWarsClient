package com.btcag.bootcamp2024.RobotWarsClient.Models;

import com.btcag.bootcamp2024.RobotWarsClient.Enums.*;

public class Move {
    private String id;
    private String playerId;
    private String gameId;
    private Directions directions;
    private MovementType movementType;

    public Move(String id, String playerId, MovementType movementType, Directions directions){
        this.id = id;
        this.playerId = playerId;
        this.gameId = gameId;
        this.movementType = movementType;
        this.directions = directions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public MovementType getMovementType() {
        return movementType;
    }

    public void setMovementType(MovementType movementType) {
        this.movementType = movementType;
    }

    public Directions getDirections(){
        return directions;
    }

    public void setDirections(Directions directions){
        this.directions = directions;
    }

}
