package BFS;

public class NumberOfIslands {
	public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid,new LinkedList<int[]>(),i,j,m,n);
                }
            }
        }
        return count;
    }
    
    void bfs(char[][] grid, Queue<int[]> q, int i, int j, int m, int n) {
        grid[i][j] = '2';
        q.offer(new int[]{i,j});
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            if (curr[0]+1 < m && grid[curr[0]+1][curr[1]] == '1') {
                q.offer(new int[]{curr[0]+1, curr[1]});
                grid[curr[0]+1][curr[1]] = '2';
            }
            if (curr[0]-1 >= 0 && grid[curr[0]-1][curr[1]] == '1') {
                q.offer(new int[]{curr[0]-1, curr[1]});
                grid[curr[0]-1][curr[1]] = '2';
            }
            if (curr[1]+1 < n && grid[curr[0]][curr[1]+1] == '1') {
                q.offer(new int[]{curr[0], curr[1]+1});
                grid[curr[0]][curr[1]+1] = '2';
            }
            if (curr[1]-1 >= 0 && grid[curr[0]][curr[1]-1] == '1') {
                q.offer(new int[]{curr[0], curr[1]-1});
                grid[curr[0]][curr[1]-1] = '2';
            }
        }
    }
}
