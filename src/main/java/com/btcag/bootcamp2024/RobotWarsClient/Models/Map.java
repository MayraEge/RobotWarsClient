package com.btcag.bootcamp2024.RobotWarsClient.Models;

import com.btcag.bootcamp2024.RobotWarsClient.Enums.Directions;

public class Map {
    private int width;
    private int height;
    private String id;
    protected static int[][] map;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.id = id;
        this.map = new int[width][height];
        boardInit();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }

    private Robot target;

    public Robot getTarget() {
        return target;
    }

    public void setTarget(Robot target) {
        this.target = target;
    }

    private void boardInit() {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                map[y][x] = 0;
            }
        }
    }

    public static boolean validTurn(Directions direction, GameRobot player) {
        switch (direction) {
            case SOUTH:
                return isValidMove(player.getY() + 1, 9);
            case WEST:
                return isValidMove(player.getX() - 1, 0);
            case NORTH:
                return isValidMove(player.getY() - 1, 0);
            case EAST:
                return isValidMove(player.getX() + 1, 14);
            case NORTH_EAST:
                return isValidMove(player.getY() - 1, 0) && isValidMove(player.getX() + 1, 14);
            case SOUTH_EAST:
                return isValidMove(player.getX() + 1, 14) && isValidMove(player.getY() + 1, 9);
            case SOUTH_WEST:
                return isValidMove(player.getX() - 1, 0) && isValidMove(player.getY() + 1, 9);
            case NORTH_WEST:
                return isValidMove(player.getX() - 1, 0) && isValidMove(player.getY() - 1, 0);
            case NOMOVE:
                return true;
            default:
                return false;
        }
    }

    private static boolean isValidMove(int coordinate, int limit) {
        return coordinate >= 0 && coordinate <= limit;
    }
}