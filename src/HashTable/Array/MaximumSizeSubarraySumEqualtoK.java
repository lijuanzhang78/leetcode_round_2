package HashTable.Array;

public class MaximumSizeSubarraySumEqualtoK {
	public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if (i > 0) nums[i] += nums[i-1];
            if (nums[i] == k) res = Math.max(i+1,res);
            if (map.containsKey(nums[i]-k)) {
                res = Math.max(res,i-map.get(nums[i]-k));
            }
            if (!map.containsKey(nums[i])) map.put(nums[i],i);
        }
        return res == Integer.MIN_VALUE? 0 : res;
    }
}
