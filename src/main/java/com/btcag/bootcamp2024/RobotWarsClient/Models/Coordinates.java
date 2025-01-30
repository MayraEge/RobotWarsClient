package com.btcag.bootcamp2024.RobotWarsClient.Models;

public class Coordinates {
    private int x;
    private int y;
    private int mapSize;
    private int mapSizeX;

    public Coordinates() {
        // Standardwerte festlegen
        this.x = 0;
        this.y = 0;
        this.mapSize = 10; // Beispielwert
        this.mapSizeX = 10;
    }

    public Coordinates(int x, int y, int mapSize, int mapSizeX) {
        this.x = x;
        this.y = y;
        this.mapSize = mapSize;
        this.mapSizeX = mapSizeX;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getMapSize() {
        return mapSize;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    public int getMapSizeX() {
        return mapSizeX;
    }

    public void setMapSizeX(int mapSizeX) {
        this.mapSizeX = mapSizeX;
    }

    public int calculatePosition() {
        return y * mapSize / mapSizeX + x;
    }
}