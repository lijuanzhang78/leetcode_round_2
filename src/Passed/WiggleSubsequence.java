package Passed;

public class WiggleSubsequence {
	 public int wiggleMaxLength(int[] nums) {
	        if (nums == null || nums.length == 0) return 0;
	        if (nums.length == 1) return 1;
	        
	        int[] dppos = new int[nums.length];
	        int[] dpneg = new int[nums.length];
	        
	        dppos[0] = dpneg[0] = 1;
	        
	        for(int i = 1; i < nums.length; i++) {
	            dppos[i] = 1;
	            dpneg[i] = 1;
	            for(int j = 0; j < i; j++) {
	                if (nums[i] > nums[j]) {
	                    dppos[i] = Math.max(dppos[i], dpneg[j] + 1);
	                }
	                if (nums[i] < nums[j]) {
	                    dpneg[i] = Math.max(dpneg[i], dppos[j] + 1);
	                }
	            }
	        }
	        return Math.max(dppos[nums.length - 1], dpneg[nums.length - 1]);
	    }
}
