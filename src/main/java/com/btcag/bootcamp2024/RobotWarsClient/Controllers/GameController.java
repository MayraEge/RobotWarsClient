package com.btcag.bootcamp2024.RobotWarsClient.Controllers;

import com.btcag.bootcamp2024.RobotWarsClient.Models.*;
import com.btcag.bootcamp2024.RobotWarsClient.Services.*;
import com.btcag.bootcamp2024.RobotWarsClient.Services.JsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//in dieser Klasse fokus auf HTTP endpunkte/Client kommunikation

@RestController
@RequestMapping("/api")
public class GameController {
    private List<Game> gameList = new ArrayList<>();
    private static final String api_url = ("https://eumth8x973.execute-api.eu-central-1.amazonaws.com/prod/");
    private final ApiService apiService;

    public GameController(ApiService apiService){
        this.apiService = apiService;
    }

    @PostMapping("/api/maps/map/{id}")
    public ResponseEntity<String> addMap(@RequestBody String json) {
        try {
            MapData[] mapDataArray = JsonParser.parseMapData(json);
            for (MapData mapData : mapDataArray) {
                Map map = new Map(mapData.getMapSizeX(), mapData.getMapSize() / mapData.getMapSizeX());
                for (MapItem item : mapData.getMapItems()) {
                    int x = item.getIndex() % mapData.getMapSizeX();
                    int y = item.getIndex() / mapData.getMapSizeX();
                    map.getMap()[x][y] = item.getType().equals("ROBOT") ? 1 : 2;
                }
                Game game = new Game(mapData.getId(), map,2);
                gameList.add(game);
            }
            return ResponseEntity.status(HttpStatus.CREATED).body("Map erfolgreich hinzugefügt!!");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ungültige JSON-Daten.");
        }
    }

    @PostMapping("/games/game")
    public ResponseEntity<String> addGame(@RequestBody Game game) {
        if (game != null) {
            gameList.add(game);
            String response = apiService.registerGame(game);
            if (response != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Spiel erfolgreich erstellt!!");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Spiel wurde nicht erstellt.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fehler: Spiel konnte nicht erstellt werden. ");
        }
    }
    @PostMapping("/games/{gameId}/join")
    public ResponseEntity<String> joinGame(@PathVariable String gameId, @RequestParam String playerName) {
        Optional<Game> gameOptional = gameList.stream().filter(game -> game.getId().equals(gameId)).findFirst();
        if (gameOptional.isPresent()) {
            Game game = gameOptional.get();
            game.addPlayerName(playerName);
            return ResponseEntity.ok("Jawoll, Spieler erfolgreich hinzugefügt!!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Spiel wurde nicht gefunden.");
        }
    }

    @GetMapping("/games/{gameId}/map")
    public ResponseEntity<Map> getGameMap(@PathVariable String gameId) {
        Optional<Game> gameOptional = gameList.stream().filter(game -> game.getId().equals(gameId)).findFirst();
        if (gameOptional.isPresent()) {
            Game game = gameOptional.get();
            return ResponseEntity.ok(game.getMap());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/server/status")
    public ResponseEntity<String> checkServerStatus() {
        String url = api_url + "status";
        String response = apiService.checkServerStatus();
        if (response != null && response.contains("OK")) {
            return ResponseEntity.ok("Verbindung zum Server erfolgreich!");
        } else {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Keine Verbindung zum Server.");
        }
    }
}

