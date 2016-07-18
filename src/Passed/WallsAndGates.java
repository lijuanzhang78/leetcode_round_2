package Passed;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
	final int[][] neighbors = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    int m, n;
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0) return;
        m = rooms.length;
        n = rooms[0].length;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    bfs(rooms, i, j);
                }
            }
        }
        return;
    }
    
    void bfs(int[][] rooms, int i, int j) {
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] visited = new boolean[m][n];
        visited[i][j] = true;
        queue.add(new int[]{i,j});
        int dis = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            dis++;
            for(int isize = 0; isize < size; isize++) {
                int[] cur = queue.poll();
                for(int[] nei: neighbors) {
                    int x = nei[0] + cur[0];
                    int y = nei[1] + cur[1];
                    if (x >= m || x < 0 || y >= n || y < 0 || rooms[x][y] == 0 || rooms[x][y] == -1 || visited[x][y])
                        continue;
                    queue.add(new int[]{x,y});
                    visited[x][y] = true;
                    rooms[x][y] = Math.min(rooms[x][y], dis);
                }    
            }
        }
    }
    
    public static void main(String[] args) {
    	int[][] rooms = { {2147483647,-1,0,2147483647},
    			{2147483647,2147483647,2147483647,-1},
    			{2147483647,-1,2147483647,-1},
    			{0,-1,2147483647,2147483647}
    	};
    	
    	new WallsAndGates().wallsAndGates(rooms);	
    }	
}
