package Sum_Questions;

public class MaximumSizeSubarraySumEqualTok {
	public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;
        int len = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                len = Math.max(len, i-map.get(sum-k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return len == Integer.MIN_VALUE? 0 : len;
    }
}
