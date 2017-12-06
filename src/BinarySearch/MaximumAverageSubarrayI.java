package BinarySearch;

public class MaximumAverageSubarrayI {
	public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        for(int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        double res = (double)nums[k-1]/k;
        for(int i = 1; i <= nums.length - k; i++) {
            res = Math.max(res,(double)(nums[i+k-1]-nums[i-1])/k);
        }
        return res;        
    }

}
