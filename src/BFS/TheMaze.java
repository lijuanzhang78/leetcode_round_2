package BFS;

public class TheMaze {
	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) return true;
        int m = maze.length;
        int n = maze[0].length;
        
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(start);
        visited[start[0]][start[1]] = true;
        
        while(!q.isEmpty()) {
            int[] s = q.remove();
            if (s[0] == destination[0] && s[1] == destination[1]) return true;
            for(int[] dir : dirs) {
                int[] curr = new int[2];
                curr[0] = s[0] + dir[0];
                curr[1] = s[1] + dir[1];
                while(curr[0] >= 0 && curr[0] < m && curr[1] >= 0 && curr[1] < n && maze[curr[0]][curr[1]] == 0) {
                    curr[0] += dir[0];
                    curr[1] += dir[1];
                }
                
                curr[0] -= dir[0];
                curr[1] -= dir[1];
                if (!visited[curr[0]][curr[1]]) {
                    q.add(curr);
                    visited[curr[0]][curr[1]] = true;
                }
            }
        }
        return false;
    }
}
