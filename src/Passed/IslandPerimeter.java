package Passed;

public class IslandPerimeter {
	public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int numIsland = 0;
        int adjEdge = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    numIsland++;
                    adjEdge += findAdjEdge(grid,i,j);
                }
            }
        }
        return numIsland*4 - adjEdge;
    }
    
    int findAdjEdge(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        if (i+1 < m && grid[i+1][j] == 1) res++;
        if (j+1 < n && grid[i][j+1] == 1) res++;
        if (i-1 >= 0 && grid[i-1][j] == 1) res++;
        if (j-1 >= 0 && grid[i][j-1] == 1) res++;
        return res;
    }
}
