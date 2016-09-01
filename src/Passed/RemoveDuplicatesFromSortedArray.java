package Passed;

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int insertpos = 0;
        for(int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                nums[insertpos++] = nums[i]; 
            }
        }
        return insertpos;
    }

}
