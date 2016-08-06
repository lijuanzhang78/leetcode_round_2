package Passed;

public class BombEnemy {
	public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        
        int res = Integer.MIN_VALUE;
        int rowEnemy = 0;
        int[] colEnemy = new int[n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (j == 0 || grid[i][j-1] == 'W') {
                    rowEnemy = 0;
                    for(int k = j; k < n; k++) {
                        if (grid[i][k] == 'E') rowEnemy++;
                        if (grid[i][k] == 'W') break;
                    }
                } 
                
                if (i == 0 || grid[i-1][j] == 'W') {
                    colEnemy[j] = 0;
                    for(int k = i; k < m; k++) {
                        if (grid[k][j] == 'E') colEnemy[j]++;
                        if (grid[k][j] == 'W') break;
                    }
                } 
                
                if (grid[i][j] == '0') {
                    res = Math.max(res, colEnemy[j] + rowEnemy);
                }
            }
        }
        return res > 0? res : 0;
    }
}
