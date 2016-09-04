package Passed;

public class WordBreak {
	 public boolean wordBreak(String s, Set<String> wordDict) {
	        if (s == null || s.length() == 0) return true;
	        
	        int n = s.length();
	        boolean[] dp = new boolean[n+1];
	        dp[0] = true;
	        
	        for(int i = 1; i <= n; i++) {
	            String str = s.substring(0,i);
	            if (wordDict.contains(str)) {
	                dp[i] = true;
	                continue;
	            }
	            for(int j = 0; j < i; j++) {
	                if (dp[j] == true && wordDict.contains(s.substring(j,i))) {
	                    dp[i] = true;
	                    continue;
	                }
	            }
	        }
	        
	        return dp[n];
	    }
}
