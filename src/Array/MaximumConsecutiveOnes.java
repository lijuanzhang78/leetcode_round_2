package Array;

public class MaximumConsecutiveOnes {
	public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = 0;
        int start = -1;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (start != -1) {
                    max = Math.max(i - start, max);
                    start = -1;
                }
            } else {
                if (start == -1) start = i;
            }
        }
        if (start != -1) max = Math.max(nums.length-start,max);
        return max;
    }
}
