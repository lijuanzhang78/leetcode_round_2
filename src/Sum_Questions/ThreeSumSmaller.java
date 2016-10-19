package Sum_Questions;

public class ThreeSumSmaller {
	public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0; i <= nums.length - 3; i++) {
            int target2 = target - nums[i];
            int j = i+1, k = nums.length - 1;
            
            while(j < k) {
                int sum = nums[j] + nums[k];
                if (sum >= target2) {
                    k--;
                } else {
                    res += k - j;
                    j++;
                }
            }
        }
        return res;
    }
}
