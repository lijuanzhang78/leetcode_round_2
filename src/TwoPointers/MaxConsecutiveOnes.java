package TwoPointers;

public class MaxConsecutiveOnes {
	public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length;) {
            int start = i;
            while(i < nums.length && nums[i] == 1) {
                i++;    
            }
            max = Math.max(max, i-start);
            while(i < nums.length && nums[i] == 0) {
                i++;
            }
        }
        return max == Integer.MIN_VALUE? 0 : max;
    }
}
