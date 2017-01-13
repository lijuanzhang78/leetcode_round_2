package DP;

public class ZerosAndOnes {
	public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) return 0;
        int[][][] dp = new int[strs.length+1][m+1][n+1];
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                dp[0][i][j] = 0;
            }
        }
        
        for(int k = 1; k <= strs.length; k++) {
            int num0 = getnumzeros(strs[k-1]);
            int num1 = strs[k-1].length() - num0;
            // it should start from 0!
            for(int i = 0; i <= m; i++) {
                for(int j = 0; j <= n; j++) {
                    if (i >= num0 && j >= num1) {
                        dp[k][i][j] = Math.max(dp[k-1][i][j], dp[k-1][i-num0][j-num1]+1);
                    } else {
                        dp[k][i][j] = dp[k-1][i][j]; // don't forget this!
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }
    
    int getnumzeros(String s) {
        int count = 0;
        char[] arr = s.toCharArray();
        for(char ch : arr) {
            if (ch == '0') count++;
        }
        return count;
    }
}
