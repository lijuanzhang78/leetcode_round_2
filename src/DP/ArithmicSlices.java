package DP;

public class ArithmicSlices {
	public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) return 0;
        int n = A.length;
        int[] dp = new int[n];
        int res = 0;
        if (A[2]-A[1] == A[1]-A[0]) {
            dp[2] = 1;
        }
        res += dp[2];
        
        for(int i = 3; i < n; i++) {
            if (A[i]-A[i-1] == A[i-1]-A[i-2]) {
                dp[i] = dp[i-1] + 1;
                res += dp[i];
            }
        }
        return res;
    }
}
