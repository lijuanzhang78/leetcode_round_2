package Passed;

public class SudokuSolver {
	public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        dfs(board, 0, m, n);
        return;
    }
    
    private boolean dfs(char[][] board, int curr, int m, int n) {
        int row = curr/9;
        int col = curr%9;
        if (row == 9) return true;
        
        if (board[row][col] != '.') {
            if(dfs(board, curr+1, m, n)) {
                return true;
            } else {
                return false;
            }
        } else {
            for(char val = '1'; val <= '9'; val++) {
                board[row][col] = val;
                if (isValid(board, row, col)) {
                    if(dfs(board, curr+1, m, n)) {
                        return true;
                    } 
                }
                board[row][col] = '.';
            }
        }
    //    board[row][col] = '.';
        return false;
    }
    
    boolean isValid(char[][] board, int row, int col) {
        char val = board[row][col];
        
        for(int i = 0; i < 9; i++) {
            if (i != col && board[row][i] == val) return false;
        }
        for(int i = 0; i < 9; i++) {
            if (i != row && board[i][col] == val) return false;
        }
        
        int x0 = row/3; 
        int y0 = col/3;
        for(int x = x0*3; x < x0*3+3; x++) {
            for(int y = y0*3; y < y0*3+3; y++) {
                if(x != row && y != col && board[x][y] == val) return false;
            }
        }
        return true;
    }
	
    public static void main(String[] args) {
    	String[] in = {
    			"..9748...",
    			"7........",
    			".2.1.9...",
    			"..7...24.",
    			".64.1.59.",
    			".98...3..",
    			"...8.3.2.",
    			"........6",
    			"...2759.."};
    	char[][] board = new char[9][9];
    	for(int i = 0; i < 9; i++) {
    		for(int j = 0; j < 9; j++) {
    			board[i][j] = in[i].charAt(j);
    		}
    	}
    	new SudokuSolver().solveSudoku(board);
    	return;  	
    }
}
