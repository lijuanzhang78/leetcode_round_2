package Passed;

public class SortColors {
	 public void sortColors(int[] nums) {
	        if (nums == null || nums.length == 0) return;
	        
	        int low = 0, high = nums.length - 1;
	        for(int i = low; i <= high;) {
	            if (nums[i] == 0) {
	                nums[i] = nums[low];
	                nums[low] = 0;
	                i++;low++;
	            } else if (nums[i] == 2) {
	                nums[i] = nums[high];
	                nums[high] = 2;
	                high--;
	            } else {
	                i++;
	            }
	        }
	        return;
	    }
}
