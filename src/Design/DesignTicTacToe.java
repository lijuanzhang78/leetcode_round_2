package Design;

public class DesignTicTacToe {
	int[] rows;
    int[] cols;
    int diag, adiag;

    /** Initialize your data structure here. */
    public DesignTicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diag = 0;
        adiag = 0;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int add = player == 1? 1 : -1;
        rows[row] += add;
        cols[col] += add;
        if (row == col) diag += add;
        if (row + col == rows.length - 1) adiag += add;
        
        int size = rows.length;
        if (Math.abs(rows[row]) == size || Math.abs(cols[col]) == size ||
            Math.abs(diag) == size || Math.abs(adiag) == size) return player;
        return 0;
    }

}
