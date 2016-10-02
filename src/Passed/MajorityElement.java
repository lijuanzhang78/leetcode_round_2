package Passed;

public class MajorityElement {
	 public int majorityElement(int[] nums) {
	        if (nums == null || nums.length == 0) return 0;
	        
	        int count = 0;
	        int majority = 0;
	        for(int i = 0; i < nums.length; i++) {
	            if (count == 0) {
	                count++;
	                majority = nums[i];
	            } else if (nums[i] == majority) {
	                count++;
	            } else {
	                count--;
	            }
	        }
	        return majority;
	    }
}
