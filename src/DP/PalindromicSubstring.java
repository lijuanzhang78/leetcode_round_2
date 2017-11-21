package DP;

public class PalindromicSubstring {
	public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            res++;
        }
        for(int i = 0; i < s.length()-1;i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                res++;
            }
        }
        for(int len = 3; len <= s.length(); len++) {
            for(int i = 0; i <= s.length() - len; i++) {
                int j = len+i-1;
                if (i+1 < s.length() && j-1 > 0 && i+1 <= j-1 && dp[i+1][j-1]) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                        res++;
                    }
                }
            }    
        }
        return res;
    }

}
