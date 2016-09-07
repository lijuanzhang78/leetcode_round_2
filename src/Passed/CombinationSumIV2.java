package Passed;

public class CombinationSumIV2 {
	public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums) {
            set.add(num);
        }
        
        int[] dp = new int[target+1];
        dp[0] = 0;
        for(int i = 1; i <= target; i++) {
            dp[i] = set.contains(i)? 1 : 0;
            for(int j = 1; j < i; j++) {
                if (set.contains(i-j)) dp[i] += dp[j];
            }
        }
        return dp[target];
    }
}
