package Passed;

public class MoveZeros {
	public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertpos = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) nums[insertpos++] = nums[i];
        }
        
        for(;insertpos < nums.length; insertpos++) {
            nums[insertpos] = 0;
        }
        return;
    }

}
