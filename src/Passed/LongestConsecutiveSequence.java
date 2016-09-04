package Passed;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        Set<Integer> set = new HashSet<Integer>();
        for(int num: nums) {
            set.add(num);
        }
        int max = Integer.MIN_VALUE;
        for(int num : nums) {
            if (set.remove(num)) {
                int val = num - 1;
                int sum = 1;
                while(set.remove(val)) {
                    sum++;
                    val--;
                }
                
                val = num+1;
                while(set.remove(val)) {
                    sum++;
                    val++;
                }
                
                max = Math.max(max, sum);
            }
        }
        
        return max;
    }
}
