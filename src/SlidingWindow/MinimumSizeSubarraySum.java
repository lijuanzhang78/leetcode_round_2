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
	
	public int minSubArrayLen_2(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while(sum >= s) {
                len = Math.min(len,i - left + 1);
                sum -= nums[left++];
            }
        }
        return len == Integer.MAX_VALUE? 0 : len;
    }	
}
