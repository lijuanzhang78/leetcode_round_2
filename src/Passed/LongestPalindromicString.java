package Passed;

public class LongestPalindromicString {
	 public String longestPalindrome(String s) {
	        if (s == null || s.length() == 0) return new String("");
	        
	        int n = s.length();
	        boolean[][] dp = new boolean[n][n];
	        
	        int start = 0, end = 0;
	        for(int i = 0; i < n; i++) {
	            dp[i][i] = true;
	            start = i;
	            end = i;
	        }
	        
	        
	        for(int i = 0; i < n - 1; i++) {
	            if(s.charAt(i) == s.charAt(i+1)) {
	                dp[i][i+1] = true;
	                start = i;
	                end = i+1;
	            }
	        }
	        
	        for(int len = 2; len <= n-1; len++) {
	            for(int i = 0; i <= n-1-len; i++) {
	                int j = i + len;
	                if (dp[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
	                    dp[i][j] = true;
	                    start = i;
	                    end = j;
	                } 
	            }
	        }
	        
	        return s.substring(start, end+1);
	    }
}
