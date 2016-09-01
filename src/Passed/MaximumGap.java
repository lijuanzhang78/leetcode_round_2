package Passed;

public class MaximumGap {
	public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        
        int n = nums.length;
        int size = (int)Math.ceil((double)(max-min)/(n-1));
        
        int[] buck_min = new int[n-1];
        int[] buck_max = new int[n-1];
        Arrays.fill(buck_min, Integer.MAX_VALUE);
        Arrays.fill(buck_max, Integer.MIN_VALUE);
        
        for(int i = 0; i < n; i++) {
            if (nums[i] == min || nums[i] == max) continue;
            int index = (nums[i] - min)/size;
            buck_min[index] = Math.min(buck_min[index], nums[i]);
            buck_max[index] = Math.max(buck_max[index], nums[i]);
        }
        
        int maxgap = Integer.MIN_VALUE;
        int previous = min;
        for(int i = 0; i < n-1; i++) {
            if (buck_min[i] == Integer.MAX_VALUE) continue;
            maxgap = Math.max(maxgap, buck_min[i] - previous);
            previous = buck_max[i];
        }
        maxgap = Math.max(maxgap, max-previous);
        return maxgap;
    }

}
