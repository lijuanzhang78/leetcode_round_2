package DP;

// pay attention to how to calculate the first larget and 2nd largest

public class PaintHouseII {
	public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) return 0;
        int n = costs.length, k = costs[0].length;
        int[][] dp = new int[n][k];
        
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int minC = -1;
        for(int i = 0; i < k; i++) {
            dp[0][i] = costs[0][i];
            if (dp[0][i] < min1) {
                min2 = min1; // this is important
                min1 = dp[0][i];
                minC = i;
            } else {
                if (dp[0][i] < min2) {
                    min2 = dp[0][i];
                }
            }
        }
        
        for(int i = 1; i < costs.length; i++) {
            int min11 = Integer.MAX_VALUE;
            int min22 = Integer.MAX_VALUE;
            int minCC = -1;
            for(int j = 0; j < k; j++) {
                if (j == minC) {
                    dp[i][j] = min2 + costs[i][j];
                } else {
                    dp[i][j] = min1 + costs[i][j];
                }
                if (dp[i][j] < min11) {
                    min22 = min11; // this is important
                    min11 = dp[i][j];
                    minCC = j;
                } else {
                    if (dp[i][j] < min22) {
                        min22 = dp[i][j];
                    }
                }
            }
            min1 = min11;
            min2 = min22;
            minC = minCC;
        }
        return min1;
    }
}
