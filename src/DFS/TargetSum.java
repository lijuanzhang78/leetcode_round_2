package DFS;

public class TargetSum {
	public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        return dfs(nums,S,0,0);
    }
    
    private int dfs(int[] nums, int S, int sum, int index) {
        if (index == nums.length) {
            if (sum == S) {
                return 1;
            } else {
                return 0;
            }
        }
        return dfs(nums,S,sum+nums[index],index+1) + dfs(nums,S,sum-nums[index],index+1);
    }
}
