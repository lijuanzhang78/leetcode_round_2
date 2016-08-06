package Passed;

public class MaximumSquare {
	public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return  0;
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] dp = new int[m][n];
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if ((i==0 || j==0) && matrix[i][j] == '1') {
                    dp[i][j] = 1;
                    res = Math.max(res, dp[i][j]);
                    continue;
                }
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j-1]),dp[i-1][j]) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res > 0? res*res : 0;
    }
}
