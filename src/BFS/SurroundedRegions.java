package BFS;

public class SurroundedRegions {
	 int[][] nei = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	    int m, n;
	    public void solve(char[][] board) {
	        if (board == null || board.length == 0 || board[0].length == 0) return;
	        m = board.length;
	        n = board[0].length;
	        for(int j = 0; j < n; j++) {
	            if (board[0][j] == 'O') {
	                bfs(board, new LinkedList<int[]>(), 0, j);
	            }
	            if (board[m-1][j] == 'O') {
	                bfs(board, new LinkedList<int[]>(), m-1, j);
	            }
	        }
	        
	        for(int i = 0; i < m; i++) {
	            if (board[i][0] == 'O') {
	                bfs(board, new LinkedList<int[]>(), i, 0);
	            }
	            if (board[i][n-1] == 'O') {
	                bfs(board, new LinkedList<int[]>(), i, n-1);
	            }
	        }
	        
	        for(int i = 0; i < m; i++) {
	            for(int j = 0; j < n; j++) {
	                if (board[i][j] == 'O') board[i][j] = 'X';
	                if (board[i][j] == '*') board[i][j] = 'O';
	            }
	        }
	    }
	    
	    void bfs(char[][] board, Queue<int[]> q, int i, int j) {
	        board[i][j] = '*';
	        q.offer(new int[]{i,j});
	        
	        while(!q.isEmpty()) {
	            int[] curr = q.poll();
	            
	            for(int[] d : nei) {
	                int x = d[0] + curr[0];
	                int y = d[1] + curr[1];
	                
	                if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O') {
	                    q.offer(new int[]{x,y});
	                    board[x][y] = '*';
	                }
	            }
	        }
	    }
}
