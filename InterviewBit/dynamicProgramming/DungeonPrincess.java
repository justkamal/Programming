package dynamicProgramming;

import java.util.Arrays;

public class DungeonPrincess {

    public int calculateMinimumHP(int[][] orb) {
        int n = orb.length;
        int m = orb[0].length;
        int[][] minLife = new int[n][m];

        for(int i = n - 1; i >= 0; --i){
            for(int j = m - 1; j >= 0; --j){
                if (i == m-1 && j == n-1){
                    minLife[i][j] = Math.max(1, 1 - orb[i][j]);
                } else if (i == m-1) {
                    minLife[i][j] = Math.max(1, minLife[i][j+1] - orb[i][j]);
                } else if (j == n-1) {
                    minLife[i][j] = Math.max(1, minLife[i+1][j] - orb[i][j]);
                } else {
                    minLife[i][j] = Math.max(1, Math.min(minLife[i+1][j], minLife[i][j+1]) - orb[i][j]);
                }
            }
        }

        return minLife[0][0];
    }

    public static void main(String[] args) {
        int[][] dungeon = {
            {-2, -3, 3},
            {-5, -10, 1},
            {10, 30, -5}
        };
        DungeonPrincess obj = new DungeonPrincess();
        System.out.print(obj.calculateMinimumHP(dungeon));
    }
}
