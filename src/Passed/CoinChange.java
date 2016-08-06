package Passed;

import java.util.Arrays;

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return 0;
        
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i = 1; i <= amount; i++) {
            for(int coin : coins) {
                if ( i-coin >= 0 && dp[i-coin] != Integer.MAX_VALUE) {
                    dp[i] = Integer.min(dp[i], dp[i-coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE? -1 : dp[amount];
    }
}
