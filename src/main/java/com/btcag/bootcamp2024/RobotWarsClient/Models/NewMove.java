package com.btcag.bootcamp2024.RobotWarsClient.Models;
import com.btcag.bootcamp2024.RobotWarsClient.Enums.*;

public class NewMove {
    private Directions directions;
    private MovementType movementType;

public NewMove (Directions directions, MovementType movementType) {
    this.directions = directions;
    this.movementType = movementType;
}
    // Getter und Setter
    public Directions getDirections() {
        return directions;
    }

    public void setDirections(Directions directions) {
        this.directions = directions;
    }

    public MovementType getMovementType() {
        return movementType;
    }

    public void setMovementType(MovementType movementType) {
        this.movementType = movementType;
    }
}
