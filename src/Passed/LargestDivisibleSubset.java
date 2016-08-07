package Passed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
	public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] pre = new int[n];
        
        pre[0] = -1;
        dp[0] = 1;
        int maxcount = dp[0];
        int maxi = 0;
        for(int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            pre[i] = -1;
            for(int j = i-1; j >= 0; j--) {
                if (nums[i]%nums[j] == 0) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if (maxcount < dp[i]) {
                maxcount = dp[i];
                maxi = i;
            }
        }
        
        while(maxi != -1) {
            res.add(nums[maxi]);
            maxi = pre[maxi];    
        }
        return res;
    }

}
