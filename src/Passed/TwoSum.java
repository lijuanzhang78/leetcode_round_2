package Passed;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) return res;
        
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                List<Integer> list = new ArrayList<>();
                map.put(nums[i], list);
            }
            map.get(nums[i]).add(i);
            if (map.containsKey(target-nums[i])) {
                if (target-nums[i] == nums[i]) {
                    if (map.get(nums[i]).size() > 1) {
                        res[0] = map.get(nums[i]).get(0);
                        res[1] = map.get(nums[i]).get(1);
                        return res;
                    }
                } else {
                    res[0] = map.get(target-nums[i]).get(0);
                    res[1] = i;
                    return res;
                }
            } 
        }
        return res;
    }
}
