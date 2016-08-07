package Passed;

import java.util.List;

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        
        int[] dp = new int[n+1];
        
        for(int layer = n - 1 ; layer >= 0; layer--) {
            for(int i = 0; i <= layer; i++) {
                dp[i] = Math.min(dp[i], dp[i+1]) + triangle.get(layer).get(i);
            }
        }
        return dp[0];
    }
}
