package DP;

public class PartitionEqualSubsetSum {
	public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) return false; // don't forget brackets for big operations!
        sum /= 2;
        
        boolean[][] dp = new boolean[nums.length+1][sum+1];
        for(int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }
        for(int i = 1; i <= nums.length; i++) {
            for(int j = 1; j <= sum; j++) {
                if (j >= nums[i-1]) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][sum];
    }
}
