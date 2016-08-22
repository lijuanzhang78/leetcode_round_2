package Passed;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++) {
            if (i == 0 || (i>0 && nums[i] != nums[i-1])) {
                int lo = i+1, hi = nums.length - 1, sum = -nums[i];
                
                while(lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while(lo < hi && nums[lo+1] == nums[lo]) lo++;
                        while(lo < hi && nums[hi-1] == nums[hi]) hi--;
                        lo++;hi--;
                    } else if (nums[lo] + nums[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }
}
