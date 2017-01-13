package DP;

public class ZerosAndOnes_2nd {
	public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) return 0;
        int[][][] dp = new int[strs.length+1][m+1][n+1];
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                dp[0][i][j] = 0;
            }
        }
        
        for(int i = 0; i < strs.length; i++) {
            int num0 = getNumzeros(strs[i]);
            int num1 = strs[i].length() - num0;
            // it should start from 0!
            for(int j = 0; j <= m; j++) {
                for(int k = 0; k <= n; k++) {
                    if (j >= num0 && k >= num1) {
                        dp[i+1][j][k] = Math.max(dp[i][j][k], dp[i][j-num0][k-num1]+1);
                    } else {
                        dp[i+1][j][k] = dp[i][j][k];
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }
    
    int getNumzeros(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') count++;
        }
        return count;
    }
}
