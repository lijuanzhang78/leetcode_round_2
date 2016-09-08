package Passed;

public class CountingNumberWithUniqueDigits {
	public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 10;
        
        if (n > 1) {
            for(int k = 2; k <= n; k++) {
                dp[k] = 9;
                int i = 1;
                while(i < k) {
                    dp[k] *= (10-i);
                    i++;
                }
                dp[k] += dp[k-1];
            }
        }
        return dp[n];
    }
}
