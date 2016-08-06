package Passed;

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int res = dp[0];
        for(int i = 1; i < n; i++) {
            dp[i] = nums[i];
            dp[i] = Math.max(dp[i-1]+nums[i], dp[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
