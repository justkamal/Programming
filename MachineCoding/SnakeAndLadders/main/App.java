package SnakeAndLadders.main;

import SnakeAndLadders.model.Board;
import SnakeAndLadders.model.Ladder;
import SnakeAndLadders.model.Player;
import SnakeAndLadders.model.Snake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class App {

    private static BufferedReader br;
    private static StringTokenizer strz;

    private static void readInput(Board board) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        board.setNSnakes(Integer.parseInt(br.readLine()));
        for (int i = 0; i < board.getNSnakes(); ++i) {
            strz = new StringTokenizer(br.readLine());
            board.getSnakeMap().put(Integer.parseInt(strz.nextToken()), new Snake(Integer.parseInt(strz.nextToken())));
        }

        board.setNLadders(Integer.parseInt(br.readLine()));
        for (int i = 0; i < board.getNLadders(); ++i) {
            strz = new StringTokenizer(br.readLine());
            board.getLadderMap().put(Integer.parseInt(strz.nextToken()), new Ladder(Integer.parseInt(strz.nextToken())));
        }

        board.setNPlayers(Integer.parseInt(br.readLine()));
        for (int i = 0; i < board.getNPlayers(); ++i) {
            board.getPlayerList().add(new Player(br.readLine()));
        }
    }

    public static void main(String[] args) throws IOException {
        Board board = new Board();
        readInput(board);
        boolean play = true;
        int turn = 0;
        int rank = 1;
        do {
            int dice = board.rollDice();
            Player currPlayer = board.getPlayerList().get(turn);
            if (currPlayer.getPosition() + dice <= 100) {
                currPlayer.setPosition(currPlayer.getPosition() + dice);
                if (board.getSnakeMap().containsKey(currPlayer.getPosition())) {
                    board.getSnakeMap().get(currPlayer.getPosition()).swallow(currPlayer);
                } else if (board.getLadderMap().containsKey(currPlayer.getPosition())) {
                    board.getLadderMap().get(currPlayer.getPosition()).climb(currPlayer);
                }
                if (currPlayer.getPosition() == 100) {
                    System.out.println(currPlayer.getName() + " finished the game at position: " + rank);
                    ++rank;
                }
            }
            if (rank == board.getNPlayers() + 1) {
                System.out.println("Game finished !");
                play = false;
            }
            turn = (turn + 1) % (board.getNPlayers());
        } while (play);
    }
}
