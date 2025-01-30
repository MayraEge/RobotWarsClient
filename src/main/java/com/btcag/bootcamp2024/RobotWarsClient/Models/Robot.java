package com.btcag.bootcamp2024.RobotWarsClient.Models;

public class Robot {
    private String id;
    private String name;
    private Coordinates coordinates;
    private int health;
    private int movementRate;
    private int attackDamage;
    private int attackRange;
    private boolean knockedOut;
    private int x;
    private int y;

    public Robot(String id, String name, int health, int movementRange, int attackDamage, int attackRange, boolean knockedOut) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.movementRate = movementRange;
        this.attackDamage = attackDamage;
        this.attackRange = attackRange;
        this.knockedOut = knockedOut;
        this.x = x;
        this.y = y;
    }

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id =id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public boolean isKnockedOut() {
        return knockedOut;
    }

    public void setKnockedOut(boolean knockedOut) {
        this.knockedOut = knockedOut;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMovementRange() {
        return movementRate;
    }

    public void setMovementRange(int movementRange) {
        this.movementRate = movementRange;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public int calculatePosition() {
        return coordinates.calculatePosition();
    }
    public int getX(){
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getY(){
        return y;
    }

    public void setY(int y){
        this.y = y;
    }


    public static void attack(Robot player, Robot target) {
        target.setHealth(target.getHealth() - player.getAttackDamage());
    }
}