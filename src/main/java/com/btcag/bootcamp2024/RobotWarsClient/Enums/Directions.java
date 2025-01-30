package com.btcag.bootcamp2024.RobotWarsClient.Enums;

public enum Directions {
    NORTH(0,-1),
    NORTH_EAST(1,-1),
    EAST(1,0),
    SOUTH_EAST(1,1),
    SOUTH(0,1),
    SOUTH_WEST(-1,1),
    WEST(-1,0),
    NORTH_WEST(-1,-1),
    NOMOVE(0,0);

    private final int x;
    private final int y;


    Directions(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}