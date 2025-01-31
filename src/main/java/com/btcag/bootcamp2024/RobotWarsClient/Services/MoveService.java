package com.btcag.bootcamp2024.RobotWarsClient.Services;

import com.btcag.bootcamp2024.RobotWarsClient.Models.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Verwaltung von Moves hier
@Service
public class MoveService {

    private List<Move> moves = new ArrayList<>();
    private List<Robot> robots = new ArrayList<>();
    private Map map;
    private GameLogic gameLogic;

    public MoveService() {
        this.map = new Map(15, 10);
        this.gameLogic = new GameLogic();
    }
    public List<Move> getMovesByGameId(String gameId) {
        List<Move> gameMoves = new ArrayList<>();
        for (Move move : moves) {
            if (move.getGameId().equals(gameId)) {
                gameMoves.add(move);
            }
        }
        return gameMoves;
    }

    public Move makeMove(String gameId, String playerId, NewMove newMove) {
        Optional<Robot> playerOpt = getRobotById(playerId);
        Optional<Robot> targetOpt = getTargetByGameId(gameId);

        if (playerOpt.isEmpty() || targetOpt.isEmpty()) {
            throw new IllegalArgumentException("Kein Spieler oder Ziel gefunden.");
        }
        Robot player = playerOpt.get();
        Robot target = targetOpt.get();

        if (player instanceof GameRobot && target instanceof GameRobot) {
            GameRobot gamePlayer = (GameRobot) player;
            GameRobot gameTarget = (GameRobot) target;

            Move move = new Move(
                    IdGenerator.generateUniqueId(),
                    playerId,
                    gameId,
                    newMove.getMovementType(),
                    newMove.getDirections()
            );
            gameLogic.executeMove(gamePlayer, gameTarget, move);
            moves.add(move);
            return move;
        } else {
            throw new IllegalArgumentException("Spieler oder Ziel ist kein GameRobot.");
        }
    }

    private Optional<Robot> getRobotById(String playerId) {
        return robots.stream()
                .filter(robot -> robot.getId().equals(playerId))
                .findFirst();
    }

    private Optional<Robot> getTargetByGameId(String gameId) {
        if (map.getId().equals(gameId)) {
            return Optional.ofNullable(map.getTarget());
        }
        return Optional.empty();
    }
}


