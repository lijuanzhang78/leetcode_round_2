package Array;

public class MaxConsecutiveOnes_2 {
	public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int start = 0;
        
        for(int i = 0; i < nums.length;) {
            if (nums[i] == 0) {
                max = Math.max(max,i - start);
                while(i < nums.length && nums[i] == 0) {
                    i++;
                }
                start = i;
            } else {
                i++;
            }            
        }
        return Math.max(max, nums.length - start);        
    }
	
}
