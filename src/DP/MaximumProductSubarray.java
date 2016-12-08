package DP;

public class MaximumProductSubarray {
	if (nums == null || nums.length == 0) return 0;
    int n = nums.length;
    int[] dp = new int[n];
    int[] neg = new int[n];
    Arrays.fill(neg, Integer.MAX_VALUE);
    if (nums[0] == 0) {
        dp[0] = 0;
        neg[0] = 0;
    } else if (nums[0] > 0) {
        dp[0] = nums[0];
    } else {
        dp[0] = nums[0];
        neg[0] = nums[0];
    }
    int res = dp[0];
    for(int i = 1; i < n; i++) {
        dp[i] = nums[i];
        if (nums[i] == 0) {
            dp[i] = 0;
            neg[i] = 0;
        } else if (nums[i] > 0) {
            dp[i] = Math.max(dp[i], dp[i-1]*nums[i]);
            if (neg[i-1] <= 0) neg[i] = neg[i-1]*nums[i];
        } else {
            neg[i] = Math.min(nums[i], dp[i-1]*nums[i]);
            if (neg[i-1] <= 0) {
                dp[i] = nums[i]*neg[i-1];
            }
        }
        res = Math.max(res,dp[i]);
    }
    return res;
}
}
