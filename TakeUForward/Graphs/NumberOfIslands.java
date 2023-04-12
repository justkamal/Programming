package Graphs;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {{0,1},{1,0},{1,1},{1,0}};

    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; ++i){
            for (int j = 0; j < grid[0].length; ++j){
                if (grid[i][j] == 1 && !visited[i][j]){
                    dfs(grid, i, j, visited);
                    ++count;
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int r, int c, boolean[][] visited){
        visited[r][c] = true;
        dfs(grid, r-1,c,visited);
        dfs(grid, r,c-1,visited);
        dfs(grid, r-1,c-1,visited);

        dfs(grid, r+1,c,visited);
        dfs(grid, r,c+1,visited);
        dfs(grid, r+1,c+1,visited);

        dfs(grid, r+1,c-1,visited);
        dfs(grid, r-1,c+1,visited);
    }
}
