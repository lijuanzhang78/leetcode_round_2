package Passed;

public class WordBreakII {
	public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() == 0) return res;
        
        if (!canBreak(s,wordDict)) return res;
        
        helper(res, "", 0, s, wordDict);
        return res;
    }
    
     public boolean canBreak(String s, Set<String> wordDict) {
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
    
    private void helper(List<String> res, String curr, int start, String s, Set<String> wordDict) {
        if (start == s.length()) {
            String sc = new String(curr);
            sc = sc.trim();
            res.add(sc);
            return;
        }
        
        for(int j = start; j < s.length(); j++) {
            String str = s.substring(start, j+1);
            if (wordDict.contains(str)) {
                curr += str + " ";
                helper(res, curr, j+1, s, wordDict);
                curr = curr.substring(0, curr.length()-(str.length()+1));
            }
        }
    }
}
