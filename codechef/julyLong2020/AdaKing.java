package julyLong2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AdaKing {

	private static BufferedReader br;
	private static char[][] board;
	private static final char MOVE = '.';
	private static final char OBSTACLE = 'X';
	private static final int[] dir = { -1, 0, 1 };
	private static final int SIZE = 8;
	
	private static void printBoard() {
		for (int i = 0; i < SIZE; ++i) {
			for (int j = 0; j < SIZE; ++j) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void fillBoard() {
		for (int i = 0; i < SIZE; ++i) {
			for (int j = 0; j < SIZE; ++j) {
				if(board[i][j] != MOVE && board[i][j] != OBSTACLE)
				board[i][j] = MOVE;
			}
		}
	}
	
	private static void boundObstacle() {
		for (int i = 0; i < SIZE; ++i) {
			for (int j = 0; j < SIZE; ++j) {
				if (board[i][j] == MOVE) {
					for (int x = 0; x < dir.length; ++x) {
						for (int y = 0; y < dir.length; ++y) {
							if (i + dir[x] >= 0 && i + dir[x] < SIZE && j + dir[y] >= 0 && j + dir[y] < SIZE)
								if (board[i + dir[x]][j + dir[y]] != MOVE
										&& board[i + dir[x]][j + dir[y]] != OBSTACLE) {
									board[i + dir[x]][j + dir[y]] = OBSTACLE;
								}
						}
					}
				}
			}
		}
	}

	private static void makeMoves(int k) {
		for (int i = 0; i < SIZE; ++i)
			for (int j = 0; j < SIZE; ++j)
				if (k-- > 0)
					board[i][j] = MOVE;
				else
					return;
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		int test = Integer.parseInt(br.readLine());
		
		/*
		 * int test = 1; Random rand = new Random();
		 */
		
		while (test-- > 0) {
			int k = Integer.parseInt(br.readLine());
			//int k = rand.nextInt(65);
			System.out.println(k);
			board = new char[SIZE][SIZE];
			makeMoves(k);
			boundObstacle();
			fillBoard();
			board[0][0] = 'O';
			printBoard();
		}
	}

}