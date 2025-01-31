package com.btcag.bootcamp2024.RobotWarsClient.Models;

public class GameRobot extends Robot {
    private Coordinates coordinates;
    private boolean knockedOut;
    private int x;
    private int y;

    public GameRobot(String id, String name, int health, int movementRate, int attackDamage, int attackRange, Coordinates coordinates, boolean knockedOut, int x, int y) {
        super(id, name, health, movementRate, attackDamage, attackRange);
        this.coordinates = coordinates;
        this.knockedOut = knockedOut;
        this.x = x;
        this.y = y;
    }

    // Getter und Setter für die zusätzlichen Felder
    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public boolean isKnockedOut() {
        return knockedOut;
    }

    public void setKnockedOut(boolean knockedOut) {
        this.knockedOut = knockedOut;
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
}
