package Passed;

public class IncreasingTripletSubsequence {
	public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        
        int c1 = Integer.MAX_VALUE, c2 = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] <= c1) {
                c1 = nums[i];
            } else if (nums[i] <= c2) {
                c2 = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
