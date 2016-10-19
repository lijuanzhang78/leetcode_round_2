package SlidingWindow;

public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int left = 0, right = 0;
        int len = Integer.MAX_VALUE;
        int sum = 0;
        while(right < nums.length) {
            while(sum < s && right < nums.length) {
                sum += nums[right++];
            }
            while (sum >= s) {
                len = Math.min(len, right-left);
                sum -= nums[left++];
            }
        }
        return len == Integer.MAX_VALUE? 0 : len;
    }
}
