package Array;

public class GameOfLife {
	 public void gameOfLife(int[][] board) {
	        if (board == null || board.length == 0 || board[0].length == 0) return;
	        int m = board.length;
	        int n = board[0].length;
	        for(int i = 0; i < m; i++) {
	            for(int j = 0; j < n; j++) {
	                int live = getNeighbor(board, i, j, m, n);
	                if ((board[i][j] & 1) == 1) {
	                    if (live >=2 && live <= 3) board[i][j] |= 1 << 1;
	                } else {
	                    if (live == 3) board[i][j] |= 1 << 1;
	                }
	            }
	        }
	        
	        for(int i = 0; i < m; i++) {
	            for(int j = 0; j < n; j++) {
	                board[i][j] >>= 1;
	            }
	        }
	    }
	    
	    int getNeighbor(int[][] board, int i, int j, int m, int n) {
	        int live = 0;
	        for(int r = i-1; r <= i+1; r++) {
	            for(int c = j-1; c <= j+1; c++) {
	                if (r >= 0 && r < m && c >= 0 && c < n) {
	                    live += board[r][c] & 1; // current bit
	                }
	            }
	        }
	        live -= board[i][j]&1;
	        return live;
	    }
}
