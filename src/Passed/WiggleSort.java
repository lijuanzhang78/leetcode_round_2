package Passed;

public class WiggleSort {
	public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        
        
        for(int i = 0; i < nums.length; i+=2) {
            if (i >= nums.length) break;
            int min = Integer.MAX_VALUE;
            int index = -1;
            for(int j = i; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    index = j;
                }
            }
            
            int temp = nums[i];
            nums[i] = min;
            nums[index] = temp;
            
            if (i+1 >= nums.length) break;
            int max  = Integer.MIN_VALUE;
            index = -1;
            for(int j = i+1; j < nums.length; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                    index = j;
                }
            }
            temp = nums[i+1];
            nums[i+1] = max;
            nums[index] = temp;;
        }
        
        return;
    }
}
