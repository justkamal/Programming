package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1, 1, 2, 1, 2, 0, 2},
                {2, 2, 1, 2, 2, 1, 1, 2, 1},
                {1, 0, 2, 0, 1, 2, 2, 1, 0},
                {2, 0, 0, 2, 2, 2, 2, 0, 2},
                {2, 1, 1, 1, 2, 0, 2, 1, 2},
                {2, 2, 1, 1, 0, 0, 1, 2, 2},
                {0, 2, 0, 2, 2, 2, 2, 2, 1},
                {2, 0, 2, 0, 1, 2, 2, 2, 2},
                {1, 1, 1, 2, 0, 1, 2, 2, 2}};

        RottenOranges mainObj = new RottenOranges();
        System.out.println("Ans: " + mainObj.orangesRotting(grid));
    }

    class Node {
        public int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public int orangesRotting(int[][] grid) {
        Queue<Node> queue = new LinkedList<>();
        int level = 0;

        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[0].length; ++j)
                if (grid[i][j] == 2)
                    queue.add(new Node(i, j));

        queue.add(new Node(-1, -1));

        while (!queue.isEmpty()) {
            Node src = queue.poll();
            if (src.x == -1 && src.y == -1) {
                if (queue.peek() != null) {
                    queue.add(src);
                    ++level;
                }
            } else{
                int[] drow = {1,0,-1,0};
                int[] dcol = {0,-1,0,1};
                for (int i = 0; i < 4; i++) {
                    int r = src.x + drow[i];
                    int c = src.y + dcol[i];
                    if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length) {
                        if (grid[r][c] == 1) {
                            grid[r][c] = 2;
                            queue.add(new Node(r, c));
                        }
                    }
                }
            }
        }
        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[0].length; ++j)
                if (grid[i][j] == 1)
                    return -1;
        return level;
    }
}
