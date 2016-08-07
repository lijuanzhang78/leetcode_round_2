package Passed;

public class DecodeWays {
	 public int numDecodings(String s) {
	        if (s == null || s.length() == 0) return 0;
	        
	        int n = s.length();
	        int[] dp = new int[n];
	        
	        dp[0] = s.charAt(0) == '0'? 0 : 1;
	        for(int i = 1; i < n; i++) {
	            if (s.charAt(i) != '0') {
	                dp[i] += dp[i-1];
	            }
	            
	            int twodigits = (s.charAt(i-1) - '0')*10 + s.charAt(i) - '0';
	            if (twodigits >= 10 && twodigits <= 26) {
	                if (i > 1){
	                    dp[i] += dp[i-2];
	                    
	                } else {
	                    dp[i] += 1;
	                }
	            }
	        }
	        return dp[n-1];
	    }
}
