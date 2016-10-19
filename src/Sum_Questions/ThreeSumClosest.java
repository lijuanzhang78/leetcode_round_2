package Sum_Questions;

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        
        int diff = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length - 3; i++) {
            int j = i+1, k = nums.length - 1;
            while(j < k) {
                int sum = nums[j] + nums[k] + nums[i];
                if (Math.abs(sum - target) < diff) {
                    diff = Math.abs(sum - target);
                    res = sum ;
                }
                if (sum > target) {
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    return target;
                }
            }
        }
        return res;
    }
}
