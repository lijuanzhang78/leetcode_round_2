package DP;

public class BombEnemy {
	public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int res = Integer.MIN_VALUE;
        int row = 0;
        int[] col = new int[n];
        
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || grid[i][j-1] == 'W') {
                    row = 0;
                    for(int k = j; k < n && grid[i][k] != 'W'; k++) {
                        if (grid[i][k] == 'E') row++;
                    }
                }
                if (i == 0 || grid[i-1][j] == 'W') {
                    col[j] = 0;
                    for(int k = i; k < m && grid[k][j] != 'W'; k++) {
                        if (grid[k][j] == 'E') col[j]++;
                    }
                }
                if (grid[i][j] == '0') res = Math.max(res,row+col[j]);
            }
        }
        return res == Integer.MIN_VALUE? 0 : res;
    }
	
	public static void main(String[] args) {
		char[][] grid = {{'W','E','W','0','E'}};
		int res = new BombEnemy().maxKilledEnemies(grid);		
	}
}
