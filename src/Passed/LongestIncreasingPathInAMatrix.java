package Passed;

public class LongestIncreasingPathInAMatrix {
	public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = helper(dp, matrix,i,j,m,n);
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
    
    int helper(int[][] dp, int[][] matrix, int i, int j, int m , int n) {
        if (dp[i][j] != Integer.MIN_VALUE) return dp[i][j];
        dp[i][j] = 1;
        
        int max = Integer.MIN_VALUE;
        if (i+1 >= 0 && i+1 < m && matrix[i+1][j] > matrix[i][j]) {
            max = Math.max(max, helper(dp, matrix, i+1, j, m, n));
        } 
        if (i-1 >= 0 && i-1 < m && matrix[i-1][j] > matrix[i][j]) {
            max = Math.max(max, helper(dp, matrix, i-1, j, m, n));
        }
        if (j+1 >= 0 && j+1 < n && matrix[i][j+1] > matrix[i][j]) {
            max = Math.max(max, helper(dp, matrix, i, j+1, m, n));
        }
        if (j-1 >= 0 && j-1 < n && matrix[i][j-1] > matrix[i][j]) {
            max = Math.max(max, helper(dp, matrix, i, j-1, m, n));
        }
        dp[i][j] += (max == Integer.MIN_VALUE? 0 : max);
        return dp[i][j];
    }
    
    public static void main(String[] args) {
    	int[][] nums = {{9,9,4}, {6,6,8}, {2,1,1}};
    	int res = new LongestIncreasingPathInAMatrix().longestIncreasingPath(nums);    	
    }

}
