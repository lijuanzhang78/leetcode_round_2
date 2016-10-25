package DP;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return false;
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j,i))) dp[i] = true;
            }
        }
        return dp[s.length()];
    }
}
