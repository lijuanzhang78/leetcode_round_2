package TwoPointers;

// 注意去重
//
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int target = -nums[i];
            int start = i+1, end = nums.length-1;
            while(start < end) {
                if (nums[start]+nums[end] < target) {
                    start++;
                } else if (nums[start]+nums[end] > target) {
                    end--;
                } else {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);list.add(nums[start]);list.add(nums[end]);
                    res.add(list);
                    start++;end--;
                    while(start < nums.length && nums[start] == nums[start-1]) start++;
                    while(end >= 0 && nums[end] == nums[end+1]) end--;
                }
            }
        }
        return res;
    }
}
