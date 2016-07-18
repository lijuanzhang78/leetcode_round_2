package Passed;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
	   final int[][] neighbors = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	    int m, n;
	    
	    public void solve(char[][] board) {
	        if (board == null || board.length == 0) return;
	        m = board.length;
	        n = board[0].length;
	        boolean[][] visited = new boolean[m][n];
	        Queue<int[]> queue = new LinkedList<int[]>();
	        
	        for(int i = 0; i < m; i++) {
//	            if (board[i][0] == 'O') {
//	                visited[i][0] = true;
//	                board[i][0] = 'Y';
//	                queue.add(new int[]{i,0});
	                bfs(queue, visited, i, 0, board);
	 //           }
	        }
	        
	        for (int i = 0; i < m; i++) {
//	             if (board[i][n-1] == 'O') {
//	                visited[i][n-1] = true;
//	                board[i][n-1] = 'Y';
//	                queue.add(new int[]{i,n-1});
	                bfs(queue, visited, i, n-1, board);
//	           }
	        }
	        
	        for (int i = 0; i < n; i++) {
//	             if (board[0][i] == 'O') {
//	                visited[0][i] = true;
//	                board[0][i] = 'Y';
//	                queue.add(new int[]{0,i});
	                bfs(queue, visited, 0, i, board);
//	           }
	        }
	        
	        for (int i = 0; i < n; i++) {
//	             if (board[m-1][i] == 'O') {
//	                visited[m-1][i] = true;
//	                board[m-1][i] = 'Y';
//	                queue.add(new int[]{m-1,i});
	                bfs(queue, visited, m-1, i, board);
//	            }
	        }
	        
	        for(int i = 0; i < m; i++) {
	            for(int j = 0; j < n; j++) {
	                if (board[i][j] == 'O') board[i][j] = 'X';
	            }
	        }
	        
	        for(int i = 0; i < m; i++) {
	            for(int j = 0; j < n; j++) {
	                if (board[i][j] == 'Y') board[i][j] = 'O';
	            }
	        }
	    }
	    
	    void bfs(Queue<int[]> queue, boolean[][] visited, int i, int j, char[][] board) {
	        if (board[i][j] != 'O' || visited[i][j]) return;
	        visited[i][j] = true;
	        board[i][j] = 'Y';
	        queue.add(new int[]{i,j});
	        
	        while (!queue.isEmpty()) {
	            int[] cur = queue.poll();
	            
	            for(int[] nei : neighbors) {
	                int x = nei[0] + cur[0];
	                int y = nei[1] + cur[1];
	                if (x >= m || x < 0 || y >= n || y < 0 || visited[x][y]) continue;
	                if (board[x][y] == 'O') {
	                    queue.add(new int[]{x,y});
	                    visited[x][y] = true;
	                    board[x][y] = 'Y';
	                }
	            }
	        }
	    }
}
