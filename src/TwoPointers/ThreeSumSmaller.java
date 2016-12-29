package TwoPointers;

public class ThreeSumSmaller {
	public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++) {
            int tar = target-nums[i];
            int low = i+1, high = nums.length - 1;
            
            while(low < high) {
                int sum = nums[low] + nums[high];
                if (sum < tar) {
                    res += high - low; // this is important!
                    low++;
                } else {
                    high--;
                }
            }
        }
        return res;
    }
}
