package Passed;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings {
	final int[][] neighbors = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    int m, n;
    
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        int[][] dis = new int[m][n];
        int[][] hit = new int[m][n];
        int buildtot = 0;
        
        for(int i = 0 ; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    buildtot++;
                    bfs(grid, i, j, dis, hit);
                }
            }
        }
        
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && hit[i][j] == buildtot && dis[i][j] > 0) {
                    res = Math.min(dis[i][j], res);
                }
            }
        }
        return res == Integer.MAX_VALUE? -1 : res;
    }
    
    void bfs(int[][] grid, int bldx, int bldy, int[][] dis, int[][] hit) {
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] visited = new boolean[m][n];
        queue.add(new int[]{bldx, bldy});
        int level = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for(int isize = 0; isize < size; isize++) {
                int[] cur = queue.poll();
                for(int[] nei: neighbors) {
                    int x = cur[0] + nei[0];
                    int y = cur[1] + nei[1];
                    
                    if(x >= m || x < 0 || y >= n || y < 0 || visited[x][y] || grid[x][y] != 0) continue;
                    queue.add(new int[]{x,y});
                    visited[x][y] = true;
                    dis[x][y] += level;
                    hit[x][y]++;
                }
            }
        }
    }
    
    public static void main(String[] args) {
    	int[][] grid = {{1,0,2,0,1},
    					{0,0,0,0,0},
    					{0,0,1,0,0}};
    	new ShortestDistanceFromAllBuildings().shortestDistance(grid);    	
    }
    
}
