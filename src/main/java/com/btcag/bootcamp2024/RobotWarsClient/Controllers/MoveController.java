package com.btcag.bootcamp2024.RobotWarsClient.Controllers;

import com.btcag.bootcamp2024.RobotWarsClient.Models.Move;
import com.btcag.bootcamp2024.RobotWarsClient.Models.NewMove;
import com.btcag.bootcamp2024.RobotWarsClient.Services.MoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//HTTP Anfragen empfangen und weiterleiten HIER

@RestController
public class MoveController {

    @Autowired
    private MoveService moveService;

    @GetMapping("/game/{gameId}")
    public List<Move> getMovesByGameId(@PathVariable String gameId) {
        return moveService.getMovesByGameId(gameId);
    }

    @GetMapping("/api/games/game/{id}/move")
    public List <Move> getAllMoves(@PathVariable String id){
        return moveService.getMovesByGameId(id);
    }

    @PostMapping("/api/games/game/{id}/move/player/{playerId}")
    public Move makeMove(@PathVariable String id, @PathVariable String playerId, @RequestBody NewMove newMove) {
        return moveService.makeMove(id, playerId, newMove);
    }
}
