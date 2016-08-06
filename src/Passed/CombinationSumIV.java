package Passed;

import java.util.Set;

public class CombinationSumIV {
	 public int combinationSum4(int[] nums, int target) {
	        if (nums == null || nums.length == 0) return 0;
	        
	        Set<Integer> set = new HashSet<Integer>();
	        for(int i = 0; i < nums.length; i++) {
	            set.add(nums[i]);
	        }
	        
	        int[] dp = new int[target+1];
	        dp[0] = 0;
	        if (set.contains(1)) dp[1] = 1;
	        for(int i = 2; i <= target; i++) {
	            if (set.contains(i)) dp[i]++;
	            for(int j = 1; j < i; j++) {
	                if (set.contains(j)) dp[i] += dp[i-j];
	            }
	        }
	        return dp[target];
	    }
}
