package DP;

public class HouserRobber {
	public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int rob = nums[0];
        int norob = 0;
        
        for(int i = 1; i < nums.length; i++) {
            int currrob = norob + nums[i];
            int currnorob = Math.max(norob, rob);
            rob = currrob;
            norob = currnorob;
        }
        return Math.max(rob, norob);
    }
	
// https://discuss.leetcode.com/topic/12024/java-dp-solution-o-n-runtime-and-o-1-space-with-inline-comment
// https://discuss.leetcode.com/topic/14504/9-lines-0ms-o-1-space-c-solution
// 对于houserRobber II，需要分成两种情况：（1）rob 0 to n-2 （2）rob 1 to n-1

}
