package Backtracking;

public class WordSearch {
	 int m, n;
	    int[][] nei = {{1,0},{-1,0},{0,1},{0,-1}};
	    public boolean exist(char[][] board, String word) {
	        if (board == null || board.length == 0 || board[0].length == 0) return false;
	        m = board.length;
	        n = board[0].length;
	        boolean[][] visited = new boolean[m][n];
	        
	        for(int i = 0; i < m; i++) {
	            for(int j = 0; j < n; j++) {
	                //if (board[i][j] == word.charAt(0)) { 这两行没有必要有
	                    if (helper(board,word,visited,0,i,j)) return true;
	                //}
	            }
	        }
	        return false;
	    }
	    
	    private boolean helper(char[][] board, String word, boolean[][] visited, int pos, int i, int j) {
	        if (pos == word.length()) return true;
	        
	        if (i >= m || i < 0 || j >= n || j < 0 || visited[i][j]) return false;
	        char currch = word.charAt(pos);
	        if (currch != board[i][j]) return false;
	        visited[i][j] = true;
	        
	        for(int[] d : nei) {
	            if (helper(board,word,visited,pos+1,i+d[0],j+d[1])) {
	                return true;
	            } 
	        }
	        visited[i][j] = false;
	        return false;
	    }
}
