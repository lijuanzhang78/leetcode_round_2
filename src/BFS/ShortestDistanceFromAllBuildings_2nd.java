package BFS;

public class ShortestDistanceFromAllBuildings_2nd {
	int[][] nei = {{1,0},{-1,0},{0,1},{0,-1}};
    int m,n;
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        int[][] dis = new int[m][n];
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid,i,j,dis,count);
                    count++;
                }
            }
        }
        
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == -count) {
                    res = Math.min(dis[i][j],res);
                }
            }
        }
        return res == Integer.MAX_VALUE? -1 : res;
    }
    
    void bfs(int[][] grid, int i, int j, int[][] dis,int count) {
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{i,j});
        visited[i][j] = true;
        int level = 0;
        
        while(q.size() > 0) {
            int size = q.size();
            level++;
            for(int isize = 0; isize < size; isize++) {
                int[] curr = q.poll();
                for(int[] d : nei) {
                    int x = d[0]+curr[0];
                    int y = d[1]+curr[1];
                    if (x>=m || x<0 || y>=n || y<0) continue;
                    if (grid[x][y] > 0 || visited[x][y]) continue;
                    q.add(new int[]{x,y});
                    grid[x][y]--;
                    dis[x][y] += level;
                    visited[x][y] = true;
                }
            }
        }
    }
}
