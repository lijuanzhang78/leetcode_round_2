package Passed;

public class RangeSumQueryImmutable {
    int[] sum;
    int[] nums;

    public NumArray(int[] nums) {
        int n = nums.length;
        this.nums = nums;
    
        sum = new int[n];
        if (nums != null && n >= 1) {
            sum[0] = nums[0];
            for(int i = 1; i < n; i++) {
                sum[i] = sum[i-1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        return sum[j] - sum[i] + nums[i];
    }
}
