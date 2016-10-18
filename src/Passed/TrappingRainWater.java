package Passed;

public class TrappingRainWater {
	public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int max = height[0];
        
        for(int i = 1; i < n; i++) {
            left[i] = Math.max(max, height[i]);
            max = left[i];
        }
        
        max = height[n-1];
        for(int i = n-2; i>=0; i--) {
            right[i] = Math.max(max, height[i]);
            max = right[i];
        }
        
        int res = 0;
        for(int i = 1; i < n; i++) {
            int unit = Math.min(left[i],right[i]) - height[i];
            if (unit > 0) res += unit;
            
        }
        return res;
    }
}
