package Passed;

public class MinimumSizeSubarrarySum {
	public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int sum = 0, front = 0;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while(sum >= s) {
                res = Math.min(res, i-front+1);
                sum -= nums[front++];
            }
        }
        return res == Integer.MAX_VALUE? 0 : res;
    }
}
