package Passed;

public class NumArray {
	int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        if (nums.length > 1) {
            for(int i = 1; i < nums.length; i++) {
                nums[i] += nums[i-1];
            }
        }
    }

    void update(int i, int val) {
        int diff = val - nums[i];
        for(int j = i; j < nums.length; j++) {
            nums[j] += diff;
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) return nums[j];
        return nums[j] - nums[i-1];
    }
    
    public static void main(String[] args) {
    	int[] nums = {1,3,5};
    	NumArray numarr = new NumArray(nums);
    	numarr.sumRange(0, 2);
    	numarr.update(1, 2);
    	numarr.sumRange(0, 2);	
    }

}
