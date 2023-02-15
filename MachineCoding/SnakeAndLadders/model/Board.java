package SnakeAndLadders.model;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Board {
    private Map<Integer, Snake> snakeMap;
    private Map<Integer, Ladder> ladderMap;
    private List<Player> playerList;
    private Random rnd;
    private int nSnakes;
    private int nLadders;
    private int nPlayers;

    public Board() {
        snakeMap = new HashMap<>();
        ladderMap = new HashMap<>();
        playerList = new ArrayList<>();
        rnd = new Random();
    }

    public int rollDice() {
        return rnd.nextInt(0, 7);
    }
}
