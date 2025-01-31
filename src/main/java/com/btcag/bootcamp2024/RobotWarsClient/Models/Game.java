package com.btcag.bootcamp2024.RobotWarsClient.Models;

import com.btcag.bootcamp2024.RobotWarsClient.Controllers.*;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private String id;
    private Map map;
    private int players;
    private List<String> playerNames;
    private String mapId;

    public Game(String id, Map map, int players) {
        this.id = id;
        this.map = map;
        this.players = players;
        this.playerNames = new ArrayList<>();
    }
        public String getId(){
            return id;
        }
        public void setId(String id){
            this.id = id;
        }
        public int getPlayers(){
        return players;
        }
        public void setPlayers(int players){
        this.players = players;
        }
        public List<String> getPlayerNames(){
        return playerNames;
        }
        public void addPlayerName(String playerNames){
        this.playerNames.add(playerNames);
        }
        public String getMapId() {
            return mapId;
        }
        public Map getBattlefield() {
            return map;
        }
        public void setBattlefield(Map map) {
            this.map = map;
        }
        public void setMapId(String mapId) {
            this.mapId = mapId;
        }
}
