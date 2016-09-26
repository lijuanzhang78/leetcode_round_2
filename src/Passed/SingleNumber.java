package Passed;

public class SingleNumber {
	public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
