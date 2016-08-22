package Passed;

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        
        int diff = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            int lo = i+1, hi = nums.length - 1;
            while(lo < hi)  {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (Math.abs(target - sum) < diff) {
                    res = sum;
                    diff = Math.abs(target - sum);
                }
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    hi--;
                } else {
                    lo++;
                }
            }
        }
        return res;
    }
}
