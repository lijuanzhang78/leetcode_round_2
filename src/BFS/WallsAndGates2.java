package BFS;

public class WallsAndGates2 {
	int[][] nei = {{1,0},{-1,0},{0,1},{0,-1}};
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        int m = rooms.length;
        int n = rooms[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) bfs(rooms,m,n,i,j);
            }
        }
        return;
    }
    
    void bfs(int[][] rooms, int m, int n, int i, int j) {
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{i,j});
        visited[i][j] = true;
        int level = 0;
        
        while(q.size() > 0) {
            int size = q.size();
            level++;
            for(int is = 0; is < size; is++) {
                int[] curr = q.poll();
                for(int[] d : nei) {
                    int x = d[0] + curr[0];
                    int y = d[1] + curr[1];
                    if (x >= m || x < 0 || y >= n || y < 0) continue;
                    if (rooms[x][y] > 0 && !visited[x][y]) {
                        rooms[x][y] = Math.min(rooms[x][y],level);
                        q.offer(new int[]{x,y});
                        visited[x][y] = true;
                    }
                }
            }
        }
    }
}
