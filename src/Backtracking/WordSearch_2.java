package Backtracking;

public class WordSearch_2 {
	int[][] nei = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            if (word == null || word.length() == 0) {
                return true;
            } else {
                return false;
            }
        }
        
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if(helper(board,word,visited,1,i,j)) {
                        return true;
                    } else {
                        visited[i][j] = false;
                    }    
                }                
            }            
        }
        return false;    
    }
    
    boolean helper(char[][] board, String word, boolean[][] visited, int pos, int i, int j) {
        if (pos == word.length()) {
            return true;
        }
        int m = board.length, n = board[0].length;
        for(int[] adj : nei) {
            int x = i + adj[0];
            int y = j + adj[1];
            
            if(x >=0 && x < m && y >=0 && y <n && board[x][y] == word.charAt(pos) && !visited[x][y]) {
                visited[x][y] = true;
                if(helper(board,word,visited,pos+1,x,y)) {
                    return true;
                } else{
                    visited[x][y] = false;
                }      
            }
        }
        return false;        
    }
}
