package DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfDistinctIslands {
	public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        List<Integer> set = null;
        Set<List<Integer>> allset = new HashSet<List<Integer>>();
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    set = new ArrayList<Integer>();
                    dfs(i,j,grid,visited,set,i,j);
                    allset.add(set);
                }                
            }
        }
        return allset.size();
    }
    
    void dfs(int r, int c, int[][] grid, boolean[][] visited, List<Integer> set, int r0, int c0) {
        visited[r][c] = true;
        int m = grid.length;
        int n = grid[0].length;
        set.add((r-r0)*2*n+(c-c0)); 
        
        if (r+1 >= 0 && r+1 < m && grid[r+1][c] == 1 && !visited[r+1][c]) {
            dfs(r+1,c,grid,visited,set,r0,c0);
        }
        if (r-1 >= 0 && r-1 < m && grid[r-1][c] == 1 && !visited[r-1][c]) {
            dfs(r-1,c,grid,visited,set,r0,c0);
        }
        if (c+1 >= 0 && c+1 < n && grid[r][c+1] == 1 && !visited[r][c+1]) {
            dfs(r,c+1,grid,visited,set,r0,c0);
        }
        if (c-1 >= 0 && c-1 < n && grid[r][c-1] == 1 && !visited[r][c-1]) {
            dfs(r,c-1,grid,visited,set,r0,c0);
        }        
    }
    
    public static void main(String[] args) {
    	int[][] grid = {
    			{1,1,1,1},{1,0,1,0},{0,0,0,0},{0,1,1,1},{1,1,0,1}};
    	NumberOfDistinctIslands test = new NumberOfDistinctIslands();
    	int res = test.numDistinctIslands(grid);
    }
}
