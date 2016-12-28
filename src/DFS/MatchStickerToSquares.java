package DFS;

public class MatchStickerToSquares {
	public boolean makesquare(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if (sum%4 != 0) return false;
        sum /= 4;
        Arrays.sort(nums);
        return dfs(nums.length-1,nums,sum,0,0,0,0);
    }
    
    boolean dfs(int index, int[] nums, int target, int sum1, int sum2, int sum3, int sum4) {
        if (sum1 > target || sum2 > target || sum3 > target || sum4 > target) return false;
        if (index == -1) {
            if (sum1 == target && sum2 == target && sum3 == target && sum4 == target) {
                return true;
            } else {
                return false;
            }
        }
        
        if (dfs(index-1,nums,target,sum1+nums[index],sum2,sum3,sum4)) return true;
        if (dfs(index-1,nums,target,sum1,sum2+nums[index],sum3,sum4)) return true;
        if (dfs(index-1,nums,target,sum1,sum2,sum3+nums[index],sum4)) return true;
        if (dfs(index-1,nums,target,sum1,sum2,sum3,sum4+nums[index])) return true;
        return false;
    }
}
