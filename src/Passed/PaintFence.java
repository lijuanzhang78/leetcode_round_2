package Passed;

public class PaintFence {
	 public int numWays(int n, int k) {
	        if (n == 0 || k == 0) return 0;
	        
	        int[] dpsame = new int[n];
	        int[] dpdiff = new int[n];
	        
	        if (n == 1) return k;
	        
	        dpsame[1] = k;
	        dpdiff[1] = k*(k-1);
	        for(int i = 2; i < n; i++) {
	            dpsame[i] = dpdiff[i-1];
	            dpdiff[i] = (dpsame[i-1] + dpdiff[i-1])*(k-1);
	        }
	        
	        return dpsame[n-1] + dpdiff[n-1];
	    }
}
