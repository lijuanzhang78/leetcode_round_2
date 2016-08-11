package dynamic_programming;

public class Triangle_top_down {
	public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                if (j > i-1) {
                    dp[i][j] = dp[i-1][j-1];
                } else if (j-1 < 0) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]);
                }
                dp[i][j] += triangle.get(i).get(j);
            }
        }
        
        int sum = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            sum = Math.min(sum, dp[n-1][i]);
            
        }
        return sum;
    }    
}
