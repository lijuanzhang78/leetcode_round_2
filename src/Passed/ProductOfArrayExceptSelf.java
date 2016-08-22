package Passed;

public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        if (nums == null || nums.length == 0) return res;
        
        int n = nums.length;
        res[0] = 1;
        for(int i = 1; i < n; i++) {
            res[i] = nums[i-1] * res[i-1];
        }
        int right = 1;
        for(int i = n-1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
