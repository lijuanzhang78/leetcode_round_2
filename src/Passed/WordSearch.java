package Passed;

public class WordSearch {
	int[][] neighbors = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
    int m, n;
    
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            if (word == null) {
                return true;
            } else {
                return false;
            }
        }
        
        List<int[]> list = new ArrayList<int[]>();
        if (word == null || word.length() == 0) return true;
        char ch = word.charAt(0);
        m = board.length;
        n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (board[i][j] == ch) {
                    list.add(new int[]{i,j});
                }
            }
        }
        
        boolean[][] visited = new boolean[m][n];
        for(int[] pos : list) {
            visited[pos[0]][pos[1]] = true;
            if (helper(pos, board, visited, word, 1)) return true;
            visited[pos[0]][pos[1]] = false;
        }
        return false;
    }
    
    private boolean helper(int[] pos, char[][] board, boolean[][] visited, String word, int start) {
        if (start == word.length()) return true;
        
        for(int[] nei : neighbors) {
            int x = pos[0] + nei[0];
            int y = pos[1] + nei[1];
            if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && word.charAt(start) == board[x][y]) {
                visited[x][y] = true;
                if(helper(new int[]{x,y}, board, visited, word, start+1)) return true;
                visited[x][y] = false;
            }
        }
        return false;
    }
}
