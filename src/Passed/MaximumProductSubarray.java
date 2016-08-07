package Passed;

public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        
        int min = 1;
        int max = 1;
        
        int res = Integer.MIN_VALUE;
        for(int i = 1; i <= nums.length; i++) {
                int temp = min;
                min = Math.min(Math.min(min*nums[i-1], max*nums[i-1]), nums[i-1]);
                max = Math.max(Math.max(max*nums[i-1], temp*nums[i-1]), nums[i-1]);
                res = Math.max(res, max);
        }
        
        return res;
    }
}
