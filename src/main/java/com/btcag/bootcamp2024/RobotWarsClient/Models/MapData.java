package com.btcag.bootcamp2024.RobotWarsClient.Models;
import java.util.List;

public class MapData {
    private String id;
    private int mapSizeX;
    private int mapSize;
    private List<MapItem> mapItems;
    private Robot target;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMapSizeX() {
        return mapSizeX;
    }

    public void setMapSizeX(int mapSizeX) {
        this.mapSizeX = mapSizeX;
    }

    public int getMapSize() {
        return mapSize;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    public Robot getTarget() {
        return target;
    }

    public void setTarget(Robot target) {
        this.target = target;
    }


    public List<MapItem> getMapItems() {
        return mapItems;
    }
    private static boolean isValidMove(int coordinate, int limit) {
        return coordinate >= 0 && coordinate <= limit;
    }

    public void setMapItems(List<MapItem> mapItems) {
        this.mapItems = mapItems;
    }
}
