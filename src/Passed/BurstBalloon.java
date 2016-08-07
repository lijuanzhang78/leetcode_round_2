package Passed;

public class BurstBalloon {
	public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        int[] inums = new int[n+2];
        inums[0] = inums[n+1] = 1;
        int ii = 1;
        for(int num : nums) {
            inums[ii++] = num;
        }
        int[][] dp = new int[n+2][n+2];
        
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n-k+1; i++) {
                int j = i + k - 1;
                for (int x = i; x <= j; x++) {
                    int temp = dp[i][x-1] + inums[i-1]*inums[x]*inums[j+1] + dp[x+1][j];
                    dp[i][j] = Math.max(dp[i][j], temp);
                }
            }
        }
        return dp[1][n];
    }
}
