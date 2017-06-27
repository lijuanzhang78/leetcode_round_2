package BFS;

public class TheMazeII {
	public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] dist = new int[m][n];
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[start[0]][start[1]] = 0;
        
        Queue<int[]> q= new LinkedList<int[]>();
        q.add(start);
        
        while(!q.isEmpty()) {
            int[] s = q.poll();
            for(int[] dir : dirs) {
                int count = 0;
                int[] curr = new int[2];
                curr[0] = s[0] + dir[0];
                curr[1] = s[1] + dir[1];
                
                while(curr[0] >= 0 && curr[0] < m && curr[1] >= 0 && curr[1] < n && maze[curr[0]][curr[1]] == 0) {
                    curr[0] += dir[0];
                    curr[1] += dir[1];
                    count++;
                }
                
                if (dist[s[0]][s[1]] + count < dist[curr[0]-dir[0]][curr[1]-dir[1]]) {
                    dist[curr[0]-dir[0]][curr[1]-dir[1]] = dist[s[0]][s[1]] + count;
                    q.add(new int[] {curr[0]-dir[0],curr[1]-dir[1]});
                }
            }
        }
        return dist[destination[0]][destination[1]] == Integer.MAX_VALUE? -1 : dist[destination[0]][destination[1]];
    }
}
