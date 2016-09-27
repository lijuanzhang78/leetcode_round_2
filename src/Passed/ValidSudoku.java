package Passed;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) return true;
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i < m; i++) {
            Set<Character> set = new HashSet<>();
            for(int j = 0; j < n; j++) {
                if (set.contains(board[i][j])) {
                    return false;
                } else {
                    if (board[i][j] != '.') set.add(board[i][j]);
                }
            }
        }
        
        for(int j = 0; j < n; j++) {
            Set<Character> set = new HashSet<>();
            for(int i = 0; i < m; i++) {
                if (set.contains(board[i][j])) {
                    return false;
                } else {
                    if (board[i][j] != '.') set.add(board[i][j]);
                }
            }
        }
        
        for(int i = 0; i <= m - 3; i += 3) {
            for(int j = 0; j <= n - 3; j += 3) {
                Set<Character> set = new HashSet<>();
                for(int p = i; p < i+3; p++) {
                    for(int q = j; q < j+3; q++) {
                        if (set.contains(board[p][q])) {
                            return false;
                        } else {
                            if (board[p][q] != '.') set.add(board[p][q]);
                        }
                    }
                }
            }
        }
        return true;
    }
}
