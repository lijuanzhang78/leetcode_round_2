package BFS;

public class ShortestDistanceFromAllBuildings {
	final int[][] neighbors = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    int m, n;
    
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        
        int k = 0;
        int[][] dis = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid,k,dis,i,j);
                    k--; // 
                }
            }
        }
        
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == k) res = Math.min(res,dis[i][j]);
            }
        }
        return res == Integer.MAX_VALUE? -1 : res;
    }
    
    void bfs(int[][] grid, int k, int[][] dis,int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a,b});
        int distance = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();
            distance++;
            for(int i = 0 ; i < size; i++) {
                int[] curr = q.poll();
                for(int[] d : neighbors) {
                    int x = curr[0] + d[0];
                    int y = curr[1] + d[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == k) {
                        grid[x][y] = k-1;
                        q.add(new int[]{x,y});
                        dis[x][y] += distance;
                    }            
                }
            }
        }
    }
}
