package TwoPointers;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < nums.length-2; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) continue;
                int start = j+1, end = nums.length-1;
                int sum = target - nums[i] - nums[j];
                while(start < end) {
                    if (nums[start] + nums[end] < sum) {
                        start++;
                    } else if (nums[start] + nums[end] > sum) {
                        end--;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);list.add(nums[j]);
                        list.add(nums[start]); list.add(nums[end]);
                        res.add(list);
                        start++;end--;
                        while(start < end && nums[start] == nums[start-1]) start++;
                        while(start < end && nums[end] == nums[end+1]) end--;
                    }
                }
            }
        }
        return res;
    }
}
