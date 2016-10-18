package Passed;

public class BattleShipsInABoard {
	int m = 0;
    int n = 0;
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return 0;
        m = board.length;
        n = board[0].length;
        
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                boolean[] flag = new boolean[2];
                if (board[i][j] == 'X' && !visited[i][j]) {
                    dfs(board, i, j, i, j, visited, flag);
                    if (flag[0] && !flag[1] || !flag[0] && flag[1] || !flag[0] && !flag[1]) res++;
                }
            }
        }
        return res;
    }
    
    private void dfs(char[][] board, int i0, int j0, int i, int j, boolean[][] visited, boolean[] flag) {
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        if (board[i][j] == '.') return;
        if (visited[i][j]) return;
        if (flag[0] == false && i != i0) flag[0] = true;
        if (flag[1] == false && j != j0) flag[1] = true;
        
        visited[i][j] = true;
        dfs(board, i0, j0, i+1, j, visited, flag);
        dfs(board, i0, j0, i-1, j, visited, flag);
        dfs(board, i0, j0, i, j+1, visited, flag);
        dfs(board, i0, j0, i, j-1, visited, flag);
    }
}
