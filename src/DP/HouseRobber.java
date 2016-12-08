package DP;

public class HouseRobber {
	public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int rob = 0;
        int notrob = 0;
        for(int i = 1; i <= nums.length; i++) {
            int curr_rob = notrob + nums[i-1];
            int curr_notrob = Math.max(rob,notrob);
            rob = curr_rob;
            notrob = curr_notrob;
        }
        return Math.max(rob, notrob);
    }
}
